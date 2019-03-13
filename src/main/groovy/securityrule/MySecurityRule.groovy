package securityrule

import groovy.util.logging.Slf4j
import io.micronaut.http.HttpRequest
import io.micronaut.multitenancy.tenantresolver.TenantResolver
import io.micronaut.security.rules.SecurityRule
import io.micronaut.security.rules.SecurityRuleResult
import io.micronaut.web.router.RouteMatch

import javax.annotation.Nullable
import javax.inject.Inject

@Slf4j
class MySecurityRule implements SecurityRule {

    @Inject
    TenantResolver tenantResolver


    @Override
    SecurityRuleResult check(HttpRequest request, @Nullable RouteMatch routeMatch, @Nullable Map<String, Object> claims) {
        String tenantId = tenantResolver.resolveTenantIdentifier()
        log.debug("tenantId:{}",tenantId)
        return SecurityRule.IS_AUTHENTICATED
    }

}
