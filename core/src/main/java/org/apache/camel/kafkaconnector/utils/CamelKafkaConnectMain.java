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
package org.apache.camel.kafkaconnector.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.DefaultErrorHandlerBuilder;
import org.apache.camel.builder.ErrorHandlerBuilderRef;
import org.apache.camel.builder.NoErrorHandlerBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.kafkaconnector.CamelConnectorConfig;
import org.apache.camel.main.SimpleMain;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.processor.idempotent.kafka.KafkaIdempotentRepository;
import org.apache.camel.spi.IdempotentRepository;
import org.apache.camel.support.processor.idempotent.MemoryIdempotentRepository;
import org.apache.camel.support.service.ServiceHelper;
import org.apache.camel.util.ObjectHelper;
import org.apache.camel.util.SensitiveUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelKafkaConnectMain extends SimpleMain {
    public static final String KAMELET_MARSHAL_TEMPLATE_PARAMETERS_PREFIX = "camel.kamelet.ckcMarshal.";
    public static final String KAMELET_UNMARSHAL_TEMPLATE_PARAMETERS_PREFIX = "camel.kamelet.ckcUnMarshal.";
    public static final String KAMELET_AGGREGATORL_TEMPLATE_PARAMETERS_PREFIX = "camel.kamelet.ckcAggregator.";
    public static final String KAMELET_IDEMPOTENT_TEMPLATE_PARAMETERS_PREFIX = "camel.kamelet.ckcIdempotent.";
    public static final String KAMELET_REMOVEHEADER_TEMPLATE_PARAMETERS_PREFIX = "camel.kamelet.ckcRemoveHeader.";

    private static final Logger LOG = LoggerFactory.getLogger(CamelKafkaConnectMain.class);

    protected volatile ConsumerTemplate consumerTemplate;
    protected volatile ProducerTemplate producerTemplate;

    public CamelKafkaConnectMain(CamelContext context) {
        super(context);
    }

    @Override
    protected void doStop() throws Exception {
        ServiceHelper.stopService(consumerTemplate);
        consumerTemplate = null;

        ServiceHelper.stopService(producerTemplate);
        producerTemplate = null;

        super.doStop();
    }

    public ProducerTemplate getProducerTemplate() {
        if (this.producerTemplate == null) {
            synchronized (this) {
                if (this.producerTemplate == null) {
                    this.producerTemplate = getCamelContext().createProducerTemplate();
                }
            }
        }

        return this.producerTemplate;
    }

    public ConsumerTemplate getConsumerTemplate() {
        if (this.consumerTemplate == null) {
            synchronized (this) {
                if (this.consumerTemplate == null) {
                    this.consumerTemplate = getCamelContext().createConsumerTemplate();
                }
            }
        }

        return this.consumerTemplate;
    }

    public static Builder builder(String from, String to) {
        return new Builder(from, to);
    }

    public static final class Builder {
        private final String from;
        private final String to;
        private Map<String, String> props;
        private String marshallDataFormat;
        private String unmarshallDataFormat;
        private int aggregationSize;
        private long aggregationTimeout;
        private String errorHandler;
        private int maxRedeliveries;
        private long redeliveryDelay;
        private boolean idempotencyEnabled;
        private String expressionType;
        private String expressionHeader;
        private int memoryDimension;
        private String idempotentRepositoryType;
        private String idempotentRepositoryTopicName;
        private String idempotentRepositoryKafkaServers;
        private int idempotentRepositoryKafkaMaxCacheSize;
        private int idempotentRepositoryKafkaPollDuration;
        private String headersExcludePattern;

        public Builder(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public Builder withProperties(Map<String, String> props) {
            this.props = new HashMap<>(props);
            return this;
        }

        public Builder withMarshallDataFormat(String dataformatId) {
            this.marshallDataFormat = dataformatId;
            return this;
        }

        public Builder withUnmarshallDataFormat(String dataformatId) {
            this.unmarshallDataFormat = dataformatId;
            return this;
        }

        public Builder withAggregationSize(int aggregationSize) {
            this.aggregationSize = aggregationSize;
            return this;
        }

        public Builder withAggregationTimeout(long aggregationTimeout) {
            this.aggregationTimeout = aggregationTimeout;
            return this;
        }

        public Builder withErrorHandler(String errorHandler) {
            this.errorHandler = errorHandler;
            return this;
        }

        public Builder withMaxRedeliveries(int maxRedeliveries) {
            this.maxRedeliveries = maxRedeliveries;
            return this;
        }

        public Builder withRedeliveryDelay(long redeliveryDelay) {
            this.redeliveryDelay = redeliveryDelay;
            return this;
        }

        public Builder withIdempotencyEnabled(boolean idempotencyEnabled) {
            this.idempotencyEnabled = idempotencyEnabled;
            return this;
        }

        public Builder withExpressionType(String expressionType) {
            this.expressionType = expressionType;
            return this;
        }

        public Builder withExpressionHeader(String expressionHeader) {
            this.expressionHeader = expressionHeader;
            return this;
        }

        public Builder withMemoryDimension(int memoryDimension) {
            this.memoryDimension = memoryDimension;
            return this;
        }

        public Builder withIdempotentRepositoryType(String idempotentRepositoryType) {
            this.idempotentRepositoryType = idempotentRepositoryType;
            return this;
        }

        public Builder withIdempotentRepositoryTopicName(String idempotentRepositoryTopicName) {
            this.idempotentRepositoryTopicName = idempotentRepositoryTopicName;
            return this;
        }

        public Builder withIdempotentRepositoryKafkaServers(String idempotentRepositoryKafkaServers) {
            this.idempotentRepositoryKafkaServers = idempotentRepositoryKafkaServers;
            return this;
        }

        public Builder withIdempotentRepositoryKafkaMaxCacheSize(int idempotentRepositoryKafkaMaxCacheSize) {
            this.idempotentRepositoryKafkaMaxCacheSize = idempotentRepositoryKafkaMaxCacheSize;
            return this;
        }

        public Builder withIdempotentRepositoryKafkaPollDuration(int idempotentRepositoryKafkaPollDuration) {
            this.idempotentRepositoryKafkaPollDuration = idempotentRepositoryKafkaPollDuration;
            return this;
        }

        public Builder withHeadersExcludePattern(String headersExcludePattern) {
            this.headersExcludePattern = headersExcludePattern;
            return this;
        }

        private String filterSensitive(Map.Entry<Object, Object> entry) {

            if (SensitiveUtils.containsSensitive((String) entry.getKey())) {
                return entry.getKey() + "=xxxxxxx";
            }
            return entry.getKey() + "=" + entry.getValue();
        }

        public CamelKafkaConnectMain build(CamelContext camelContext) {
            CamelKafkaConnectMain camelMain = new CamelKafkaConnectMain(camelContext);
            camelMain.configure().setAutoConfigurationLogSummary(false);
            //TODO: make it configurable
            camelMain.configure().setDumpRoutes(true);

            Properties camelProperties = new Properties();
            camelProperties.putAll(props);

            //error handler
            camelMain.getCamelContext().getRegistry().bind("ckcErrorHandler", new DefaultErrorHandlerBuilder());
            if (errorHandler != null) {
                switch (errorHandler) {
                    case "no":
                        camelMain.getCamelContext().getRegistry().bind("ckcErrorHandler", new NoErrorHandlerBuilder());
                        break;
                    case "default":
                        camelMain.getCamelContext().getRegistry().bind("ckcErrorHandler", new DefaultErrorHandlerBuilder().maximumRedeliveries(maxRedeliveries).redeliveryDelay(redeliveryDelay));
                        break;
                    default:
                        break;
                }
            }

            //dataformats
            if (!ObjectHelper.isEmpty(marshallDataFormat)) {
                camelProperties.put(KAMELET_MARSHAL_TEMPLATE_PARAMETERS_PREFIX + "marshal", marshallDataFormat);
            }
            if (!ObjectHelper.isEmpty(unmarshallDataFormat)) {
                camelProperties.put(KAMELET_UNMARSHAL_TEMPLATE_PARAMETERS_PREFIX + "unmarshal", unmarshallDataFormat);
            }

            //aggregator
            if (!ObjectHelper.isEmpty(aggregationSize)) {
                camelProperties.put(KAMELET_AGGREGATORL_TEMPLATE_PARAMETERS_PREFIX + "aggregationSize", String.valueOf(aggregationSize));
            }
            if (!ObjectHelper.isEmpty(aggregationTimeout)) {
                camelProperties.put(KAMELET_AGGREGATORL_TEMPLATE_PARAMETERS_PREFIX + "aggregationTimeout", String.valueOf(aggregationTimeout));
            }

            //idempotency
            if (idempotencyEnabled) {
                switch (expressionType) {
                    case "body":
                        camelProperties.put(KAMELET_IDEMPOTENT_TEMPLATE_PARAMETERS_PREFIX + "idempotentExpression", "${body}");
                        break;
                    case "header":
                        camelProperties.put(KAMELET_IDEMPOTENT_TEMPLATE_PARAMETERS_PREFIX + "idempotentExpression", "${headers." + expressionHeader + "}");
                        break;
                    default:
                        break;
                }
                // Instantiating the idempotent Repository here and inject it in registry to be referenced
                IdempotentRepository idempotentRepo = null;
                switch (idempotentRepositoryType) {
                    case "memory":
                        idempotentRepo = MemoryIdempotentRepository.memoryIdempotentRepository(memoryDimension);
                        break;
                    case "kafka":
                        idempotentRepo = new KafkaIdempotentRepository(idempotentRepositoryTopicName, idempotentRepositoryKafkaServers, idempotentRepositoryKafkaMaxCacheSize, idempotentRepositoryKafkaPollDuration);
                        break;
                    default:
                        break;
                }
                camelMain.getCamelContext().getRegistry().bind("ckcIdempotentRepository", idempotentRepo);
            }

            //remove headers
            if (!ObjectHelper.isEmpty(headersExcludePattern)) {
                camelProperties.put(KAMELET_REMOVEHEADER_TEMPLATE_PARAMETERS_PREFIX + "headersExcludePattern", headersExcludePattern);
            }

            // log filtered properties and set initial camel properties
            List<String> filteredProps = camelProperties.entrySet().stream().map(this::filterSensitive).collect(Collectors.toList());
            LOG.info("Setting initial properties in Camel context: [{}]", filteredProps);
            camelMain.setInitialProperties(camelProperties);

            camelMain.configure().addRoutesBuilder(new RouteBuilder() {
                public void configure() {

                    //create marshal template
                    routeTemplate("ckcMarshal")
                            .templateParameter("marshal", "dummyDataformat")
                            .from("kamelet:source")
                            .marshal("{{marshal}}")
                            .to("kamelet:sink");

                    //create unmarshal template
                    routeTemplate("ckcUnMarshal")
                            .templateParameter("unmarshal", "dummyDataformat")
                            .from("kamelet:source")
                            .marshal("{{unmarshal}}")
                            .to("kamelet:sink");

                    //create aggregator template
                    routeTemplate("ckcAggregator")
                            //TODO: change CamelConnectorConfig.CAMEL_CONNECTOR_AGGREGATE_NAME to ckcAggregationStrategy?
                            .templateParameter("aggregationStrategy", CamelConnectorConfig.CAMEL_CONNECTOR_AGGREGATE_NAME)
                            .templateParameter("aggregationSize", "1")
                            .templateParameter("aggregationTimeout", String.valueOf(Long.MAX_VALUE))
                            .from("kamelet:source")
                            .aggregate(constant(true))
                                .aggregationStrategyRef("{{aggregationStrategy}}")
                                .completionSize("{{aggregationSize}}")
                                .completionTimeout("{{aggregationTimeout}}")
                                .to("kamelet:sink")
                            .end();

                    //create idempotent template
                    routeTemplate("ckcIdempotent")
                            .templateParameter("idempotentExpression", "dummyExpression")
                            .templateParameter("idempotentRepository", "ckcIdempotentRepository")
                            .from("kamelet:source")
                            .idempotentConsumer(simple("{{idempotentExpression}}")).messageIdRepositoryRef("{{idempotentRepository}}")
                            .to("kamelet:sink");

                    //create removeHeader template
                    routeTemplate("ckcRemoveHeader")
                            .templateParameter("headersExcludePattern", "(?!)")
                            .from("kamelet:source")
                            .removeHeaders("{{headersExcludePattern}}")
                            .to("kamelet:sink");

                    //creating source template
                    routeTemplate("ckcSource")
                            .templateParameter("fromUrl")
                            .templateParameter("errorHandler", "ckcErrorHandler")
                            .from("{{fromUrl}}")
                            .errorHandler(new ErrorHandlerBuilderRef("{{errorHandler}}"))
                            .to("kamelet:sink");

                    //creating sink template
                    routeTemplate("ckcSink")
                            .templateParameter("toUrl")
                            .templateParameter("errorHandler", "ckcErrorHandler")
                            .from("kamelet:source")
                            .errorHandler(new ErrorHandlerBuilderRef("{{errorHandler}}"))
                            .to("{{toUrl}}");

                    //creating the actual route
                    ProcessorDefinition<?> rd = from(from);
                    if (!ObjectHelper.isEmpty(marshallDataFormat)) {
                        rd = rd.kamelet("ckcMarshal");
                    }
                    if (!ObjectHelper.isEmpty(unmarshallDataFormat)) {
                        rd = rd.kamelet("ckcUnMarshal");
                    }
                    if (getContext().getRegistry().lookupByName("aggregate") != null) {
                        rd = rd.kamelet("ckcAggregator");
                    }
                    if (idempotencyEnabled) {
                        rd = rd.kamelet("ckcIdempotent");
                    }
                    rd = rd.kamelet("ckcRemoveHeader");
                    rd.toD(to);
                }
            });

            return camelMain;
        }
    }
}
