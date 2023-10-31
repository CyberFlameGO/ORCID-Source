<#--

    =============================================================================

    ORCID (R) Open Source
    http://orcid.org

    Copyright (c) 2012-2014 ORCID, Inc.
    Licensed under an MIT-Style License (MIT)
    http://orcid.org/open-source-license

    This copyright and license information (including a link to the full license)
    shall be included in its entirety in all copies or substantial portion of
    the software.

    =============================================================================

-->
<#import "email_macros.ftl" as emailMacros />

<@emailMacros.msg "email.welcome.your_id.id" /><@emailMacros.space />${orcidId}<br/>
<@emailMacros.msg "email.welcome.your_id.link" /><@emailMacros.space /><a href="${baseUri}/${orcidId}" target="orcid.blank">${baseUri}/${orcidId}</a>

<@emailMacros.msg "email.welcome" /><@emailMacros.space />${userName}
<@emailMacros.msg "email.welcome.congrats" />

<@emailMacros.msg "email.welcome.verify.1" />

<@emailMacros.msg "email.welcome.verify.2" />

<@emailMacros.msg "email.welcome.verify.3" />

<@emailMacros.msg "email.button" />

<@emailMacros.msg "email.welcome.verify.4" />

${verificationUrl}?lang=${locale}

<@emailMacros.msg "email.welcome.please_visit_your" /><@emailMacros.space /><@emailMacros.msg "email.welcome.researcher_homepage" /><@emailMacros.space /><@emailMacros.msg "email.welcome.for_more_information" />

<#include "email_footer.ftl"/>
