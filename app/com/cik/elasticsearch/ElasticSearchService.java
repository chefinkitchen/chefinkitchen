package com.cik.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.mapping.PutMapping;

import java.util.LinkedHashMap;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;



import com.cik.elasticsearch.dto.BankDetails;
import com.cik.elasticsearch.dto.BaseSearchRequest;
import com.cik.elasticsearch.dto.BaseSearchResponse;

public class ElasticSearchService {

	private JestClient client = null;
	private static final String esURL =play.Play.application().configuration().getString("esurl");

	public ElasticSearchService() {

		init();
	}

	public void init() {
		// Construct a new Jest client according to configuration via factory
		JestClientFactory factory = new JestClientFactory();
		System.out.println("Elastic Search Url == "+esURL);
		factory.setHttpClientConfig(new HttpClientConfig.Builder(esURL)
				.multiThreaded(true).build());
		if (client == null)
			client = factory.getObject();
	}

	

	public void createIndex(String indexName) {
		try {
			client.execute(new CreateIndex.Builder(indexName).build());
			System.out.println();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void createMapping(String indexName, String indexType,
			String jSONMapping) {
		PutMapping putMapping = new PutMapping.Builder(indexName, indexType,
				jSONMapping).build();
		// "{ \"document\" : { \"properties\" : { \"message\" : {\"type\" : \"string\", \"store\" : \"yes\"} } } }"
		try {
			client.execute(putMapping);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * public static void createMappingWithObject(String indexName, String
	 * indexType, String fieldName) { RootObjectMapper.Builder
	 * rootObjectMapperBuilder = new RootObjectMapper.Builder("cik").add( new
	 * StringFieldMapper.Builder(fieldName).store(true) ); DocumentMapper
	 * documentMapper = new DocumentMapper.Builder(indexName, null,
	 * rootObjectMapperBuilder).build(null); String expectedMappingSource =
	 * documentMapper.mappingSource().toString(); PutMapping putMapping = new
	 * PutMapping.Builder( indexName, indexType, expectedMappingSource
	 * ).build(); try { client.execute(putMapping); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	public void createIndexDoucment(String indexName, String intexType,
			LinkedHashMap<String, String> source) {
		Index index = new Index.Builder(source).index(indexName)
				.type(intexType).build();
		try {
			client.execute(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createInexByObj(String indexName, String intexType, Object obj) {
		Index index = new Index.Builder(obj).index(indexName).type(intexType)
				.build();
		try {
			client.execute(index);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String searchByJSon(String indexName, String indexType,
			String jSONSearchString) {

		List<BankDetails> searchResults = null;
		Search search = new Search.Builder(jSONSearchString)
		// multiple index or types can be added.
				.addIndex(indexName).build();
		SearchResult result = null;
		try {
			result = client.execute(search);
			List<Hit<BankDetails, Void>> t = result.getHits(BankDetails.class);

			for (Hit<BankDetails, Void> hit : t) {
				System.out.println("hit==   " + hit.source);

			}

			System.out.println(result.getTotal());
			// List<SearchResult.Hit<BaseSearchResponse, Void>> searchResult =
			// result.getHits(BaseSearchResponse.class);
			searchResults = result.getSourceAsObjectList(BankDetails.class);
			System.out.println("Size of result " + searchResults.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.getJsonString();
	}

	public List<BaseSearchResponse> searchByObj(String indexName,
			String indexType, BaseSearchRequest searchReq) {

		List<BaseSearchResponse> searchResults = null;
		SearchResult result = null;
		QueryBuilder qb = QueryBuilders
				.boolQuery()
				.should(QueryBuilders.termQuery("chefName",
						searchReq.getChefName()))
				.should(QueryBuilders.termQuery("menuName",
						searchReq.getMenuName()))
				.should(QueryBuilders.termQuery("cuisineType",
						searchReq.getCuisineType()))
				.should(QueryBuilders.termQuery("cuisineName",
						searchReq.getCuisineName()))
				.should(QueryBuilders.termQuery("location",
						searchReq.getLocation()))
				.should(QueryBuilders.termQuery("zipCode",
						searchReq.getZipCode())).minimumNumberShouldMatch(1);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(qb.toString());

		Search search = (Search) new Search.Builder(
				searchSourceBuilder.toString())
		// multiple index or types can be added.
				.addIndex(indexName).addType(indexType).build();

		try {

			result = client.execute(search);
			searchResults = result
					.getSourceAsObjectList(BaseSearchResponse.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Search search = new Search.Builder(object) // multiple index or types
		 * can be added. .addIndex(indexName).build(); SearchResult result =
		 * null; try { result = client.execute(search); List<Hit<BankDetails,
		 * Void>> t = result.getHits(BankDetails.class);
		 * 
		 * for (Hit<BankDetails, Void> hit : t) { System.out.println("hit==   "
		 * + hit.source);
		 * 
		 * }
		 * 
		 * System.out.println(result.getTotal()); //
		 * List<SearchResult.Hit<BaseSearchResponse, Void>> searchResult = //
		 * result.getHits(BaseSearchResponse.class); searchResults =
		 * result.getSourceAsObjectList(BankDetails.class);
		 * System.out.println("Size of result " + searchResults.size()); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return searchResults;
	}
}
