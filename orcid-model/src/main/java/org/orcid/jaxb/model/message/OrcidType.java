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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.09 at 01:52:56 PM BST 
//

package org.orcid.jaxb.model.message;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * <p>
 * Java class for orcid-type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="orcid-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="user"/>
 *     &lt;enumeration value="group"/>
 *     &lt;enumeration value="client"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "orcid-type")
@XmlEnum
public enum OrcidType implements Serializable {
    @XmlEnumValue("admin")
    ADMIN("admin"), @XmlEnumValue("user")
    USER("user"), @XmlEnumValue("group")
    GROUP("group"), @XmlEnumValue("premium_group")
    PREMIUM_GROUP("premium_group"), @XmlEnumValue("client")
    CLIENT("client"),@XmlEnumValue("creator")
    CREATOR("creator"), @XmlEnumValue("premium-creator")
    PREMIUM_CREATOR("premium-creator"), @XmlEnumValue("updater")
    UPDATER("updater"), @XmlEnumValue("premium-updater")
    PREMIUM_UPDATER("premium-updater");
    private final String value;

    OrcidType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
    
    public static OrcidType fromValue(String v) {
        for (OrcidType c : OrcidType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
