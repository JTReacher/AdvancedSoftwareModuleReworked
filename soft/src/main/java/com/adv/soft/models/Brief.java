package com.adv.soft.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "briefs")
@Entity
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long briefId; // unique brief id
    private long userId; // userid of creating user
    private long companyId; // The company id that the creating user is linked to
    private String skillsRequired; // The skills the company wants for this brief
    private String jobDescription; // Paragraph outlining job description
    private String industry; // Defined industry from the standard list
    private double pay; // Expected pay for this brief
    private Instant creationDate; // Date brief was created
    private Date startDate = new Date(); // Expected start date of freelancing job
    private Date endDate = new Date(); // Expected end date
    private long workDuration = endDate.getTime() - startDate.getTime(); // Calc for length of brief
    private long durationDays = TimeUnit.MILLISECONDS.toDays(workDuration); // Calc for length of brief in days

}


//TODO: Delete the false date declaration you have used for start and end date
//I need logic to handle this and either allow null or insert a default date.