package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private String num1;
    private String num2;
    private String type;
    private double result;
}
