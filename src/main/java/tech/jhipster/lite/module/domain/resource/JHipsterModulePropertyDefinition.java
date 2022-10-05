package tech.jhipster.lite.module.domain.resource;

import java.util.Optional;
import tech.jhipster.lite.error.domain.Assert;
import tech.jhipster.lite.module.domain.properties.JHipsterModuleProperties;
import tech.jhipster.lite.module.domain.properties.JHipsterPropertyDescription;
import tech.jhipster.lite.module.domain.properties.JHipsterPropertyExample;
import tech.jhipster.lite.module.domain.properties.JHipsterPropertyKey;
import tech.jhipster.lite.module.domain.properties.JHipsterPropertyType;

public class JHipsterModulePropertyDefinition {

  private final JHipsterPropertyType type;
  private final boolean mandatory;
  private final JHipsterPropertyKey key;
  private final Optional<JHipsterPropertyDescription> description;
  private final Optional<JHipsterPropertyExample> example;
  private final int order;

  private JHipsterModulePropertyDefinition(JHipsterModulePropertyDefinitionBuilder builder) {
    Assert.notNull("type", builder.type);
    Assert.notBlank("key", builder.key);

    type = builder.type;
    mandatory = builder.mandatory;
    key = new JHipsterPropertyKey(builder.key);
    description = JHipsterPropertyDescription.of(builder.description);
    example = JHipsterPropertyExample.of(builder.example);
    order = builder.order;
  }

  public static JHipsterModulePropertyDefinition basePackageProperty() {
    return mandatoryStringProperty(JHipsterModuleProperties.BASE_PACKAGE_PARAMETER)
      .description("Base java package")
      .example("tech.jhipster.lite")
      .order(-300)
      .build();
  }

  public static JHipsterModulePropertyDefinition projectNameProperty() {
    return mandatoryStringProperty(JHipsterModuleProperties.PROJECT_NAME_PARAMETER)
      .description("Project full name")
      .example("JHipster Project")
      .order(-200)
      .build();
  }

  static JHipsterModulePropertyDefinition projectBaseNameProperty() {
    return mandatoryStringProperty(JHipsterModuleProperties.PROJECT_BASE_NAME_PARAMETER)
      .description("Project short name (only letters and numbers)")
      .example("jhipster")
      .order(-100)
      .build();
  }

  static JHipsterModulePropertyDefinition serverPortProperty() {
    return mandatoryIntegerProperty(JHipsterModuleProperties.SERVER_PORT_PARAMETER)
      .description("Server port")
      .example("8080")
      .order(-50)
      .build();
  }

  public static JHipsterModulePropertyDefinition endOfLineProperty() {
    return optionalStringProperty("endOfLine").description("Type of line break (lf or crlf)").example("lf").order(100).build();
  }

  public static JHipsterModulePropertyDefinition indentationProperty() {
    return optionalIntegerProperty(JHipsterModuleProperties.INDENTATION_PARAMETER)
      .description("Number of spaces in indentation")
      .example("2")
      .order(500)
      .build();
  }

  public static JHipsterModulePropertyDefinition oktaDomain() {
    return mandatoryStringProperty("oktaDomain").description("Okta domain").example("dev-123456.okta.com").order(600).build();
  }

  public static JHipsterModulePropertyDefinition auth0Domain() {
    return mandatoryStringProperty("auth0Domain").description("Auth0 domain").example("dev-123456.us.auth0.com").order(700).build();
  }

  public static JHipsterModulePropertyDefinition clientId() {
    return mandatoryStringProperty("clientId")
      .description("Client ID for OIDC application")
      .example("0oab8eb55Kb9jdMIr5d6")
      .order(800)
      .build();
  }

  public static JHipsterModulePropertyDefinitionOptionalFieldsBuilder mandatoryStringProperty(String key) {
    return builder().type(JHipsterPropertyType.STRING).mandatory(true).key(key);
  }

  public static JHipsterModulePropertyDefinitionOptionalFieldsBuilder optionalStringProperty(String key) {
    return builder().type(JHipsterPropertyType.STRING).mandatory(false).key(key);
  }

  public static JHipsterModulePropertyDefinitionOptionalFieldsBuilder mandatoryIntegerProperty(String key) {
    return builder().type(JHipsterPropertyType.INTEGER).mandatory(true).key(key);
  }

  public static JHipsterModulePropertyDefinitionOptionalFieldsBuilder optionalIntegerProperty(String key) {
    return builder().type(JHipsterPropertyType.INTEGER).mandatory(false).key(key);
  }

  public static JHipsterModulePropertyDefinitionOptionalFieldsBuilder mandatoryBooleanProperty(String key) {
    return builder().type(JHipsterPropertyType.BOOLEAN).mandatory(true).key(key);
  }

  public static JHipsterModulePropertyDefinitionOptionalFieldsBuilder optionalBooleanProperty(String key) {
    return builder().type(JHipsterPropertyType.BOOLEAN).mandatory(false).key(key);
  }

  public static JHipsterModulePropertyDefinitionTypeBuilder builder() {
    return new JHipsterModulePropertyDefinitionBuilder();
  }

  public JHipsterPropertyType type() {
    return type;
  }

  public JHipsterPropertyKey key() {
    return key;
  }

  public boolean isMandatory() {
    return mandatory;
  }

  public Optional<JHipsterPropertyDescription> description() {
    return description;
  }

  public Optional<JHipsterPropertyExample> example() {
    return example;
  }

  public int order() {
    return order;
  }

  public static class JHipsterModulePropertyDefinitionBuilder
    implements
      JHipsterModulePropertyDefinitionTypeBuilder,
      JHipsterModulePropertyDefinitionOptionalityBuilder,
      JHipsterModulePropertyDefinitionKeyBuilder,
      JHipsterModulePropertyDefinitionOptionalFieldsBuilder {

    private JHipsterPropertyType type;
    private boolean mandatory;
    private String key;
    private String description;
    private String example;
    private int order;

    private JHipsterModulePropertyDefinitionBuilder() {}

    @Override
    public JHipsterModulePropertyDefinitionOptionalityBuilder type(JHipsterPropertyType type) {
      this.type = type;

      return this;
    }

    @Override
    public JHipsterModulePropertyDefinitionKeyBuilder mandatory(boolean mandatory) {
      this.mandatory = mandatory;

      return this;
    }

    @Override
    public JHipsterModulePropertyDefinitionOptionalFieldsBuilder key(String key) {
      this.key = key;

      return this;
    }

    @Override
    public JHipsterModulePropertyDefinitionOptionalFieldsBuilder description(String description) {
      this.description = description;

      return this;
    }

    @Override
    public JHipsterModulePropertyDefinitionOptionalFieldsBuilder example(String example) {
      this.example = example;

      return this;
    }

    @Override
    public JHipsterModulePropertyDefinitionOptionalFieldsBuilder order(int order) {
      this.order = order;

      return this;
    }

    @Override
    public JHipsterModulePropertyDefinition build() {
      return new JHipsterModulePropertyDefinition(this);
    }
  }

  public interface JHipsterModulePropertyDefinitionTypeBuilder {
    JHipsterModulePropertyDefinitionOptionalityBuilder type(JHipsterPropertyType type);
  }

  public interface JHipsterModulePropertyDefinitionOptionalityBuilder {
    JHipsterModulePropertyDefinitionKeyBuilder mandatory(boolean mandatory);
  }

  public interface JHipsterModulePropertyDefinitionKeyBuilder {
    JHipsterModulePropertyDefinitionOptionalFieldsBuilder key(String key);
  }

  public interface JHipsterModulePropertyDefinitionOptionalFieldsBuilder {
    JHipsterModulePropertyDefinitionOptionalFieldsBuilder description(String description);

    JHipsterModulePropertyDefinitionOptionalFieldsBuilder example(String example);

    JHipsterModulePropertyDefinitionOptionalFieldsBuilder order(int order);

    JHipsterModulePropertyDefinition build();
  }
}
