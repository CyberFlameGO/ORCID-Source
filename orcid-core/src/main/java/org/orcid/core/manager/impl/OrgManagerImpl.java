/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2013 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.core.manager.impl;

import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;

import org.orcid.core.manager.OrgManager;
import org.orcid.persistence.dao.OrgDao;
import org.orcid.persistence.dao.OrgDisambiguatedDao;
import org.orcid.persistence.jpa.entities.OrgDisambiguatedEntity;
import org.orcid.persistence.jpa.entities.OrgEntity;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * 
 * @author Will Simpson
 * 
 */
public class OrgManagerImpl implements OrgManager {

    private static final String[] AMBIGUOUS_ORGS_HEADER = new String[] { "id", "name", "city", "region", "country" };

    @Resource
    private OrgDao orgDao;

    @Resource
    private OrgDisambiguatedDao orgDisambiguatedDao;

    @Override
    public List<OrgEntity> getAmbiguousOrgs() {
        return orgDao.getAmbiguousOrgs();
    }

    @Override
    public void writeAmbiguousOrgs(Writer writer) {
        @SuppressWarnings("resource")
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(AMBIGUOUS_ORGS_HEADER);
        for (OrgEntity orgEntity : getAmbiguousOrgs()) {
            String[] line = new String[] { String.valueOf(orgEntity.getId()), orgEntity.getName(), orgEntity.getCity(), orgEntity.getRegion(),
                    orgEntity.getCountry().value() };
            csvWriter.writeNext(line);
        }
    }

    @Override
    public List<OrgEntity> getOrgs(String searchTerm, int firstResult, int maxResults) {
        return orgDao.getOrgs(searchTerm, firstResult, maxResults);
    }

    @Override
    public OrgEntity createUpdate(OrgEntity org) {
        OrgEntity existingOrg = orgDao.findByNameCityRegionAndCountry(org.getName(), org.getCity(), org.getRegion(), org.getCountry());
        if (existingOrg != null) {
            return existingOrg;
        }
        orgDao.persist(org);
        return org;
    }

    @Override
    public OrgEntity createUpdate(OrgEntity org, Long orgDisambiguatedId) {
        OrgEntity existingOrg = orgDao.findByNameCityRegionAndCountry(org.getName(), org.getCity(), org.getRegion(), org.getCountry());
        if (existingOrg != null) {
            org = existingOrg;
        }
        if (org.getOrgDisambiguated() == null) {
            OrgDisambiguatedEntity disambiguatedOrg = orgDisambiguatedDao.find(orgDisambiguatedId);
            if (disambiguatedOrg == null) {
                throw new IllegalArgumentException("No such disambiguated org with id=" + orgDisambiguatedId);
            }
            org.setOrgDisambiguated(disambiguatedOrg);
        }
        return orgDao.merge(org);
    }

}
