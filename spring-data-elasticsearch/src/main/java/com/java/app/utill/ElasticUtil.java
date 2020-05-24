package com.java.app.utill;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;

public class ElasticUtil {
	
	@Autowired
	static
	Client client;
	
	/**
	 * @param indexName
	 * @param client
	 * @return 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static  boolean createSettings(String indexName) throws ExecutionException, InterruptedException {
	    CreateIndexRequest request = new CreateIndexRequest(indexName);
	    request.settings(Settings.builder()
	            .put("index.max_inner_result_window", 250)
	            .put("index.write.wait_for_active_shards", 1)
	            .put("index.query.default_field", "paragraph")
	            .put("index.number_of_shards", 3)
	            .put("index.number_of_replicas", 2)
	    );
	    CreateIndexResponse createIndexResponse = ((Client) client).admin().indices().create(request).get();
	    System.out.println("Index : " + createIndexResponse.index() + " Created");
	    return createIndexResponse.isAcknowledged();
	}
	/**
	 * @param indexName
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void createSettingsWithAnalyzer(String indexName) throws ExecutionException, InterruptedException, IOException {
	    CreateIndexRequest request = new CreateIndexRequest(indexName);
	    request.source("{\n" +
	            "        \"settings\":{\n" +
	            "            \"index\": {\n" +
	            "                \"analysis\": {\n" +
	            "                    \"normalizer\": {\n" +
	            "                        \"lowercaseNormalizer\": {\n" +
	            "                            \"type\": \"custom\",\n" +
	            "                            \"char_filter\": [],\n" +
	            "                            \"filter\": [\"lowercase\"]\n" +
	            "                        }\n" +
	            "                    },\n" +
	            "                    \"analyzer\": {\n" +
	            "                        \"englishAnalyzer\": {\n" +
	            "                            \"tokenizer\": \"standard\",\n" +
	            "                            \"char_filter\": [\n" +
	            "                                \"html_strip\"\n" +
	            "                            ],\n" +
	            "                            \"filter\" : [\n" +
	            "                                \"standard\",\n" +
	            "                                \"lowercase\",\n" +
	            "                                \"trim\"\n" +
	            "                            ]\n" +
	            "                        }\n" +
	            "                    },\n" +
	            "                    \"filter\" : {\n" +
	            "                        \"snowballStemmer\": {\n" +
	            "                            \"type\": \"snowball\",\n" +
	            "                            \"language\": \"english\"\n" +
	            "                        }\n" +
	            "                    }\n" +
	            "                }\n" +
	            "            }\n" +
	            "        }\n" +
	            "    }",XContentType.JSON);
	    CreateIndexResponse createIndexResponse = client.admin().indices().create(request).get();
	    System.out.println("Index : "+createIndexResponse.index()+" Created");
	    
	}
	
	
	
	
}
