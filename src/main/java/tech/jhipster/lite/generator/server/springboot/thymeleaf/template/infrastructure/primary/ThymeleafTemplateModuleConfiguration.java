package tech.jhipster.lite.generator.server.springboot.thymeleaf.template.infrastructure.primary;

import static tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.thymeleaf.template.application.ThymeleafTemplateModuleApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class ThymeleafTemplateModuleConfiguration {

  @Bean
  public JHipsterModuleResource thymeleafTemplateModule(ThymeleafTemplateModuleApplicationService thymeleafTemplate) {
    return JHipsterModuleResource
      .builder()
      .slug(THYMELEAF_TEMPLATE)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addConfigurationFormat().build()
      )
      .apiDoc("Thymeleaf", "Add thymeleaf skeleton layout files to the project")
      .organization(JHipsterModuleOrganization.builder().addDependency(SPRING_BOOT_THYMELEAF).build())
      .tags("server", "spring", "spring-boot", "thymeleaf")
      .factory(thymeleafTemplate::buildThymeleafTemplateModule);
  }
}
