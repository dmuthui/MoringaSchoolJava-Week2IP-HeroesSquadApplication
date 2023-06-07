package ke.co.safaricom.model;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Squad {
    private Integer squadId;
    private String squad;
    private Integer size;
    private String cause;

    public Squad(Integer squadId, String squad, Integer size, String cause) {
        this.squadId = squadId;
        this.squad = squad;
        this.size = size;
        this.cause = cause;
    }


    public Integer getSquadId() {
        return squadId;
    }

    public void setSquadId(Integer squadId) {
        this.squadId = squadId;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad.toUpperCase();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "squadId=" + squadId +
                ", squad='" + squad + '\'' +
                ", size=" + size +
                ", cause='" + cause + '\'' +
                '}';
    }
}