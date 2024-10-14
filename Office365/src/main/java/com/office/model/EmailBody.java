package com.office.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailBody {

	private String fromEmail;
	private String toEmail;
	private String subject;
	private String messageBody;

}
