package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Poll (
    @JsonProperty("id")
    String id,

    @JsonProperty("question")
    String question,

    @JsonProperty("question_entities")
    MessageEntity[] questionEntities,

    @JsonProperty("options")
    PollOption[] options,

    @JsonProperty("total_voter_count")
    Long totalVoterCount,

    @JsonProperty("is_closed")
    Boolean isClosed,

    @JsonProperty("is_anonymous")
    Boolean isAnonymous,

    @JsonProperty("type")
    String type,

    @JsonProperty("allows_multiple_answers")
    Boolean allowsMultipleAnswers,

    @JsonProperty("correct_option_id")
    Long correctOptionId,

    @JsonProperty("explanation")
    String explanation,

    @JsonProperty("explanation_entities")
    MessageEntity[] explanationEntities,

    @JsonProperty("open_period")
    Long openPeriod,

    @JsonProperty("close_date")
    Long closeDate
) {}
