package com.adv.soft.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Calendar;
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
    private long id; // unique brief id
    private long companyId; // The company id that the creating user is linked to
    private Skill skill; // The skills the company wants for this brief
    private String jobDescription; // Paragraph outlining job description
    private String industry; // Defined industry from the standard list
    private double pay; // Expected pay for this brief
    
    private Date creationDate = Calendar.getInstance().getTime(); // Date brief was created


    //TODO: Fix this functionality. Look for databinder and put in controllers.
    /*     private long userId; //TODO: add this functionality */
    /* private Date startDate = new Date(); // Expected start date of freelancing job
    private Date endDate = new Date(); // Expected end date
    private long workDuration = endDate.getTime() - startDate.getTime(); // Calc for length of brief
    private long durationDays = TimeUnit.MILLISECONDS.toDays(workDuration); // Calc for length of brief in days */

}