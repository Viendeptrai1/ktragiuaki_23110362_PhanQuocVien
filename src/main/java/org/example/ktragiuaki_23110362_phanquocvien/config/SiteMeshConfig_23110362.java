package org.example.ktragiuaki_23110362_phanquocvien.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "sitemesh", urlPatterns = {"/*"})
public class SiteMeshConfig_23110362 extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder
                .addDecoratorPath("/admin/*", "/WEB-INF/views/decorators/admin.jsp")
                .addDecoratorPath("/*", "/WEB-INF/views/decorators/user.jsp")
                .addExcludedPath("/assets/*")
                .addExcludedPath("/static/*")
                .addExcludedPath("/WEB-INF/views/decorators/*")
                .addExcludedPath("/login")
                .addExcludedPath("/register");
    }
}
