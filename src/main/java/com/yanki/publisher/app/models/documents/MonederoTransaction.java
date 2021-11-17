package com.yanki.publisher.app.models.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("moneyTransaction")
public class MonederoTransaction {
    @Id
    private String id;
    @NotNull
    private String originNumber;
    @NotNull
    private String destinationNumber;
    @NotNull
    private Double amount;
    private Status status;
    private int condition;
    private LocalDateTime createAt;
    public enum Status {
        PENDING,
        REJECTED,
        SUCCESSFUL
    }
}
