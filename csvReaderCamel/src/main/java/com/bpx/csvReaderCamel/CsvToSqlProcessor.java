package com.bpx.csvReaderCamel;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class CsvToSqlProcessor implements Processor{
	public void process(Exchange exchange) throws Exception {
		System.out.println("Inserting Files Now ================================");
        Map<String, String> row = exchange.getIn().getBody(Map.class);
        String insertQuery = String.
        		format("INSERT INTO del_rep_sample(sender,receiver,country_code,message_id,conversation_id,request_id,conversation_type,campaign,template,message_payload,payload_type,message_type,MO_MT,sent,delivered,`read`,failed,error_code,error_description,`source`,pair_id) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                        row.get("campaign"),
                        row.get("conversation_id"),
                        row.get("conversation_type"),
                        row.get("country_code"),
                        row.get("delivered"),
                        row.get("error_code"),
                        row.get("error_description"),
                        row.get("failed"),
                        row.get("message_id"),
                        row.get("message_payload"),
                        row.get("message_type"),
                        row.get("MO_MT"),
                        row.get("pair_id"),
                        row.get("payload_type"),
                        row.get("read"),
                        row.get("receiver"),
                        row.get("request_id"),
                        row.get("sender"),
                        row.get("sent"),
                        row.get("source"),
                        row.get("template")
                );
        exchange.getIn().setBody(insertQuery);
    }
}
