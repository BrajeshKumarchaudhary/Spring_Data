# Spring_Data
# Spring-Data-elasticSearch
---

### Create Spring boot starter project goto file->new->Spring Starter project
![Step1](https://github.com/BrajeshKumarchaudhary/springcloudconfig_properties/blob/master/spring-elastic/spring-elastic1.png)

---

### Following directory Structure
![Step2](https://github.com/BrajeshKumarchaudhary/springcloudconfig_properties/blob/master/spring-elastic/2.png)

---

### Add elastic search host in property file

```text
elasticsearch.clustername = elasticsearch
elasticsearch.host = localhost
elasticsearch.port = 9300
 ```
---

### Add spring-data elastic serach dependency

```text
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency> 
```

---

### Add Lambok and Swagger Dependency


```text
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<optional>true</optional>
</dependency>
          <!-- Swagger Dependency -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<!-- To use Swagger UI, one additional Maven dependency is required -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency> 
```
---

### Create Elastic config file

public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    @Bean
    public Client client() throws Exception {

        return new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(EsHost), EsPort));
    }
    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

## Similarly create Swagger Config

public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Api Market Place For Any Solution")
				.description("List of APIs Published Under MarketPlace").version("1.0.0").termsOfServiceUrl("")
				.license("Api MarketPlace").licenseUrl("Api").build();
	}

}


---

