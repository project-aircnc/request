package analysis;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Request_table")
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String requester;
    private String requestInfo;
    private String requestStatus;

    @PostPersist
    public void onPostPersist(){
        Canceled canceled = new Canceled();
        BeanUtils.copyProperties(this, canceled);
        canceled.publishAfterCommit();


    }

    @PrePersist
    public void onPrePersist(){
        Requested requested = new Requested();
        BeanUtils.copyProperties(this, requested);
        requested.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }
    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }
    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }




}
