/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.jaxb.model.record.summary;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.orcid.jaxb.model.record.Activity;
import org.orcid.jaxb.model.record.CreatedDate;
import org.orcid.jaxb.model.record.FuzzyDate;
import org.orcid.jaxb.model.record.LastModifiedDate;
import org.orcid.jaxb.model.record.Source;
import org.orcid.jaxb.model.record.Visibility;
import org.orcid.jaxb.model.record.VisibilityType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "createdDate", "lastModifiedDate",  "source", "departmentName", "roleTitle", "startDate", "endDate"  })
@XmlRootElement(name = "employment-summary", namespace = "http://www.orcid.org/ns/employment")
public class EmploymentSummary implements VisibilityType, Activity, Serializable {
            
    private static final long serialVersionUID = 6988028860521476955L;
    @XmlElement(name="department-name", namespace = "http://www.orcid.org/ns/employment")
    protected String departmentName;
    @XmlElement(name="role-title", namespace = "http://www.orcid.org/ns/employment")
    protected String roleTitle;
    @XmlElement(name="start-date", namespace = "http://www.orcid.org/ns/common")
    protected FuzzyDate startDate;
    @XmlElement(name="end-date", namespace = "http://www.orcid.org/ns/common")
    protected FuzzyDate endDate;
    
    @XmlElement(namespace = "http://www.orcid.org/ns/common")
    protected Source source;
    @XmlElement(name="last-modified-date", namespace = "http://www.orcid.org/ns/common")
    protected LastModifiedDate lastModifiedDate;
    @XmlElement(name="created-date", namespace = "http://www.orcid.org/ns/common")
    protected CreatedDate createdDate;

    @XmlAttribute(name="put-code")
    protected String putCode;
    @XmlAttribute
    protected Visibility visibility;
          
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public FuzzyDate getStartDate() {
        return startDate;
    }

    public void setStartDate(FuzzyDate startDate) {
        this.startDate = startDate;
    }

    public FuzzyDate getEndDate() {
        return endDate;
    }

    public void setEndDate(FuzzyDate endDate) {
        this.endDate = endDate;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public LastModifiedDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LastModifiedDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public CreatedDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(CreatedDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getPutCode() {
        return putCode;
    }

    public void setPutCode(String putCode) {
        this.putCode = putCode;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
    
    @Override
    public String retrieveSourcePath() {
        if (source == null) {
            return null;
        }
        return source.retrieveSourcePath();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
        result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
        result = prime * result + ((putCode == null) ? 0 : putCode.hashCode());
        result = prime * result + ((roleTitle == null) ? 0 : roleTitle.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((visibility == null) ? 0 : visibility.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmploymentSummary other = (EmploymentSummary) obj;
        if (createdDate == null) {
            if (other.createdDate != null)
                return false;
        } else if (!createdDate.equals(other.createdDate))
            return false;
        if (departmentName == null) {
            if (other.departmentName != null)
                return false;
        } else if (!departmentName.equals(other.departmentName))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (lastModifiedDate == null) {
            if (other.lastModifiedDate != null)
                return false;
        } else if (!lastModifiedDate.equals(other.lastModifiedDate))
            return false;
        if (putCode == null) {
            if (other.putCode != null)
                return false;
        } else if (!putCode.equals(other.putCode))
            return false;
        if (roleTitle == null) {
            if (other.roleTitle != null)
                return false;
        } else if (!roleTitle.equals(other.roleTitle))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (visibility != other.visibility)
            return false;
        return true;
    }
}
