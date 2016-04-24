package net.atos.pip.davay.bilet;

import java.util.List;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class GeneralData {

    private String dateLottery; // TODO narazie na stringu - ale czy jest sens na DATE
    private String answers;
    private String correctAnswer;
    private String percentOfCorrectAnswers;
    private int numberOfWinnings;
    private List<User> winners;
    private List<User> participants;

    public GeneralData() {
    }

    public GeneralData(String dateLottery, String answers, String correctAnswer, String percentOfCorrectAnswers,
                       int numberOfWinnings, List<User> winners, List<User> participants) {
        this.dateLottery = dateLottery;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.percentOfCorrectAnswers = percentOfCorrectAnswers;
        this.numberOfWinnings = numberOfWinnings;
        this.winners = winners;
        this.participants = participants;
    }

    public String getDateLottery() {
        return dateLottery;
    }

    public void setDateLottery(String dateLottery) {
        this.dateLottery = dateLottery;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getPercentOfCorrectAnswers() {
        return percentOfCorrectAnswers;
    }

    public void setPercentOfCorrectAnswers(String percentOfCorrectAnswers) {
        this.percentOfCorrectAnswers = percentOfCorrectAnswers;
    }

    public int getNumberOfWinnings() {
        return numberOfWinnings;
    }

    public void setNumberOfWinnings(int numberOfWinnings) {
        this.numberOfWinnings = numberOfWinnings;
    }

    public List<User> getWinners() {
        return winners;
    }

    public void setWinners(List<User> winners) {
        this.winners = winners;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public static GeneralData convertFromJsonObject(JsonObject jsonObject) {

        //DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");

        GeneralData generalData = new GeneralData();
        generalData.setAnswers(jsonObject.getString("answers"));
        generalData.setCorrectAnswer(jsonObject.getString("correctAnswer"));
        generalData.setNumberOfWinnings(jsonObject.getInteger("numberOfWinnings"));
        generalData.setParticipants(jsonObject.getJsonArray("participants").getList());
        generalData.setWinners(jsonObject.getJsonArray("winners").getList());
        generalData.setPercentOfCorrectAnswers(jsonObject.getString("percentOfCorrectAnswers"));
        generalData.setDateLottery(jsonObject.getString("dateLottery"));
        return generalData;
    }

    public JsonObject convertToJsonObject(GeneralData generalData) {
        JsonObject jsonObject = new JsonObject()
                .put("answers", answers)
                .put("correctAnswer", correctAnswer)
                .put("numberOfWinnings", numberOfWinnings)
                .put("percentOfCorrectAnswers", percentOfCorrectAnswers)
                .put("participants", new JsonArray(participants))
                .put("winners", new JsonArray(winners))
                .put("dateLottery", dateLottery.toString());
        return jsonObject;
    }
}