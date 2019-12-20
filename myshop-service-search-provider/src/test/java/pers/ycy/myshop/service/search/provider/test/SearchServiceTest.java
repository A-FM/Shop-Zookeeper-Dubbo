package pers.ycy.myshop.service.search.provider.test;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ycy.myshop.service.search.domain.TbItemResult;
import pers.ycy.myshop.service.search.provider.MyShopServiceSearchProviderApplication;
import pers.ycy.myshop.service.search.provider.mapper.TbItemResultMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyShopServiceSearchProviderApplication.class)
public class SearchServiceTest {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private TbItemResultMapper tbItemResultMapper;

    @Test
    public void testSelectAll(){
        List<TbItemResult> tbItemResults = tbItemResultMapper.selectAll();
        for (TbItemResult tbItemResult : tbItemResults) {
            System.out.println(tbItemResult.getTbItemCname());
        }
    }

    @Test
    public void testAddDocument() throws IOException, SolrServerException {
        SolrInputDocument solrInputFields = new SolrInputDocument();
        solrInputFields.addField("id",1029944528);
        solrInputFields.addField("tb_item_cname","平板电视");
        solrInputFields.addField("tb_item_title","LG 55EC9300-CA 55英寸智能OLED电视");
        solrInputFields.addField("tb_item_sell_point","【正常发货】自有物流，安全保障！送货安装同步！");
        solrInputFields.addField("tb_item_desc","介绍");

        solrClient.add(solrInputFields);
        solrClient.commit();
    }

    @Test
    public void testDeleteDocument() throws IOException, SolrServerException {
        solrClient.deleteByQuery("*:*");
        solrClient.commit();
    }

    @Test
    public void initSolr() throws IOException, SolrServerException {
        List<TbItemResult> tbItemResults = tbItemResultMapper.selectAll();
        SolrInputDocument solrInputFields = null;
        int count = 0;
        for (TbItemResult tbItemResult : tbItemResults) {
            System.out.println(count++);
            solrInputFields = new SolrInputDocument();
            solrInputFields.addField("id",tbItemResult.getId());
            solrInputFields.addField("tb_item_cid",tbItemResult.getTbItemCid());
            solrInputFields.addField("tb_item_cname",tbItemResult.getTbItemCname());
            solrInputFields.addField("tb_item_title",tbItemResult.getTbItemTitle());
            solrInputFields.addField("tb_item_sell_point",tbItemResult.getTbItemSellPoint());
            solrInputFields.addField("tb_item_desc",tbItemResult.getTbItemDesc());
            solrClient.add(solrInputFields);
            solrClient.commit();
        }
    }

    @Test
    public void testSearch() throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("手机");
        solrQuery.setStart(0);
        solrQuery.setRows(10);
        solrQuery.set("df","tb_item_keywords");
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("tb_item_title");
        solrQuery.setHighlightSimplePre("<span style='color:red';>");
        solrQuery.setHighlightSimplePost("</span>");
        QueryResponse queryResponse = solrClient.query(solrQuery);

        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();

        SolrDocumentList results = queryResponse.getResults();
        for (SolrDocument result : results) {
            System.out.println(result.get("tb_item_title"));

            List<String> strings = highlighting.get(result.get("id")).get("tb_item_title");
            if(strings!=null&&strings.size()>0){
                System.out.println(strings.get(0));
            }
        }
    }

}