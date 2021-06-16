/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.kafkaconnector.hwcloudiam;

import java.util.Map;
import javax.annotation.Generated;
import org.apache.camel.kafkaconnector.CamelSinkConnectorConfig;
import org.apache.kafka.common.config.ConfigDef;

@Generated("This class has been generated by camel-kafka-connector-generator-maven-plugin, remove this annotation to prevent it from being generated.")
public class CamelHwcloudiamSinkConnectorConfig
        extends
            CamelSinkConnectorConfig {

    public static final String CAMEL_SINK_HWCLOUDIAM_PATH_OPERATION_CONF = "camel.sink.path.operation";
    public static final String CAMEL_SINK_HWCLOUDIAM_PATH_OPERATION_DOC = "Operation to be performed";
    public static final String CAMEL_SINK_HWCLOUDIAM_PATH_OPERATION_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_AUTHENTICATION_KEY_CONF = "camel.sink.endpoint.authenticationKey";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_AUTHENTICATION_KEY_DOC = "Authentication key for the cloud user";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_AUTHENTICATION_KEY_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_ENDPOINT_CONF = "camel.sink.endpoint.endpoint";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_ENDPOINT_DOC = "IAM endpoint url. Carries higher precedence than region parameter based client initialization";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_ENDPOINT_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_GROUP_ID_CONF = "camel.sink.endpoint.groupId";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_GROUP_ID_DOC = "Group ID to perform operation with";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_GROUP_ID_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_IGNORE_SSL_VERIFICATION_CONF = "camel.sink.endpoint.ignoreSslVerification";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_IGNORE_SSL_VERIFICATION_DOC = "Ignore SSL verification";
    public static final Boolean CAMEL_SINK_HWCLOUDIAM_ENDPOINT_IGNORE_SSL_VERIFICATION_DEFAULT = false;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_HOST_CONF = "camel.sink.endpoint.proxyHost";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_HOST_DOC = "Proxy server ip/hostname";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_HOST_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PASSWORD_CONF = "camel.sink.endpoint.proxyPassword";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PASSWORD_DOC = "Proxy authentication password";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PASSWORD_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PORT_CONF = "camel.sink.endpoint.proxyPort";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PORT_DOC = "Proxy server port";
    public static final Integer CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PORT_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_USER_CONF = "camel.sink.endpoint.proxyUser";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_USER_DOC = "Proxy authentication user";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_USER_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_REGION_CONF = "camel.sink.endpoint.region";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_REGION_DOC = "IAM service region. This is lower precedence than endpoint based configuration";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_REGION_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SECRET_KEY_CONF = "camel.sink.endpoint.secretKey";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SECRET_KEY_DOC = "Secret key for the cloud user";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SECRET_KEY_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SERVICE_KEYS_CONF = "camel.sink.endpoint.serviceKeys";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SERVICE_KEYS_DOC = "Configuration object for cloud service authentication";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SERVICE_KEYS_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_USER_ID_CONF = "camel.sink.endpoint.userId";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_USER_ID_DOC = "User ID to perform operation with";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_USER_ID_DEFAULT = null;
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_LAZY_START_PRODUCER_CONF = "camel.sink.endpoint.lazyStartProducer";
    public static final String CAMEL_SINK_HWCLOUDIAM_ENDPOINT_LAZY_START_PRODUCER_DOC = "Whether the producer should be started lazy (on the first message). By starting lazy you can use this to allow CamelContext and routes to startup in situations where a producer may otherwise fail during starting and cause the route to fail being started. By deferring this startup to be lazy then the startup failure can be handled during routing messages via Camel's routing error handlers. Beware that when the first message is processed then creating and starting the producer may take a little time and prolong the total processing time of the processing.";
    public static final Boolean CAMEL_SINK_HWCLOUDIAM_ENDPOINT_LAZY_START_PRODUCER_DEFAULT = false;
    public static final String CAMEL_SINK_HWCLOUDIAM_COMPONENT_LAZY_START_PRODUCER_CONF = "camel.component.hwcloud-iam.lazyStartProducer";
    public static final String CAMEL_SINK_HWCLOUDIAM_COMPONENT_LAZY_START_PRODUCER_DOC = "Whether the producer should be started lazy (on the first message). By starting lazy you can use this to allow CamelContext and routes to startup in situations where a producer may otherwise fail during starting and cause the route to fail being started. By deferring this startup to be lazy then the startup failure can be handled during routing messages via Camel's routing error handlers. Beware that when the first message is processed then creating and starting the producer may take a little time and prolong the total processing time of the processing.";
    public static final Boolean CAMEL_SINK_HWCLOUDIAM_COMPONENT_LAZY_START_PRODUCER_DEFAULT = false;
    public static final String CAMEL_SINK_HWCLOUDIAM_COMPONENT_AUTOWIRED_ENABLED_CONF = "camel.component.hwcloud-iam.autowiredEnabled";
    public static final String CAMEL_SINK_HWCLOUDIAM_COMPONENT_AUTOWIRED_ENABLED_DOC = "Whether autowiring is enabled. This is used for automatic autowiring options (the option must be marked as autowired) by looking up in the registry to find if there is a single instance of matching type, which then gets configured on the component. This can be used for automatic configuring JDBC data sources, JMS connection factories, AWS Clients, etc.";
    public static final Boolean CAMEL_SINK_HWCLOUDIAM_COMPONENT_AUTOWIRED_ENABLED_DEFAULT = true;

    public CamelHwcloudiamSinkConnectorConfig(
            ConfigDef config,
            Map<String, String> parsedConfig) {
        super(config, parsedConfig);
    }

    public CamelHwcloudiamSinkConnectorConfig(Map<String, String> parsedConfig) {
        this(conf(), parsedConfig);
    }

    public static ConfigDef conf() {
        ConfigDef conf = new ConfigDef(CamelSinkConnectorConfig.conf());
        conf.define(CAMEL_SINK_HWCLOUDIAM_PATH_OPERATION_CONF, ConfigDef.Type.STRING, CAMEL_SINK_HWCLOUDIAM_PATH_OPERATION_DEFAULT, ConfigDef.Importance.HIGH, CAMEL_SINK_HWCLOUDIAM_PATH_OPERATION_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_AUTHENTICATION_KEY_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_AUTHENTICATION_KEY_DEFAULT, ConfigDef.Importance.HIGH, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_AUTHENTICATION_KEY_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_ENDPOINT_CONF, ConfigDef.Type.STRING, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_ENDPOINT_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_ENDPOINT_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_GROUP_ID_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_GROUP_ID_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_GROUP_ID_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_IGNORE_SSL_VERIFICATION_CONF, ConfigDef.Type.BOOLEAN, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_IGNORE_SSL_VERIFICATION_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_IGNORE_SSL_VERIFICATION_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_HOST_CONF, ConfigDef.Type.STRING, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_HOST_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_HOST_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PASSWORD_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PASSWORD_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PASSWORD_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PORT_CONF, ConfigDef.Type.INT, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PORT_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_PORT_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_USER_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_USER_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_PROXY_USER_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_REGION_CONF, ConfigDef.Type.STRING, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_REGION_DEFAULT, ConfigDef.Importance.HIGH, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_REGION_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SECRET_KEY_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SECRET_KEY_DEFAULT, ConfigDef.Importance.HIGH, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SECRET_KEY_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SERVICE_KEYS_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SERVICE_KEYS_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_SERVICE_KEYS_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_USER_ID_CONF, ConfigDef.Type.PASSWORD, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_USER_ID_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_USER_ID_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_ENDPOINT_LAZY_START_PRODUCER_CONF, ConfigDef.Type.BOOLEAN, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_LAZY_START_PRODUCER_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_ENDPOINT_LAZY_START_PRODUCER_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_COMPONENT_LAZY_START_PRODUCER_CONF, ConfigDef.Type.BOOLEAN, CAMEL_SINK_HWCLOUDIAM_COMPONENT_LAZY_START_PRODUCER_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_COMPONENT_LAZY_START_PRODUCER_DOC);
        conf.define(CAMEL_SINK_HWCLOUDIAM_COMPONENT_AUTOWIRED_ENABLED_CONF, ConfigDef.Type.BOOLEAN, CAMEL_SINK_HWCLOUDIAM_COMPONENT_AUTOWIRED_ENABLED_DEFAULT, ConfigDef.Importance.MEDIUM, CAMEL_SINK_HWCLOUDIAM_COMPONENT_AUTOWIRED_ENABLED_DOC);
        return conf;
    }
}