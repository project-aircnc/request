package analysis;

import analysis.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReceptionCompleted_UpdateStatus(@Payload ReceptionCompleted receptionCompleted){

        if(receptionCompleted.isMe()){
            System.out.println("##### listener UpdateStatus : " + receptionCompleted.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAnalysisCompleted_UpdateStatus(@Payload AnalysisCompleted analysisCompleted){

        if(analysisCompleted.isMe()){
            System.out.println("##### listener UpdateStatus : " + analysisCompleted.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAnalysisStarted_UpdateStatus(@Payload AnalysisStarted analysisStarted){

        if(analysisStarted.isMe()){
            System.out.println("##### listener UpdateStatus : " + analysisStarted.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverEquipStatusUpdated_UpdateStatus(@Payload EquipStatusUpdated equipStatusUpdated){

        if(equipStatusUpdated.isMe()){
            System.out.println("##### listener UpdateStatus : " + equipStatusUpdated.toJson());
        }
    }

}
