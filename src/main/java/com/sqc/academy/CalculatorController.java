package com.sqc.academy;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculate(
            @RequestParam int firstNumber,
            @RequestParam int secondNumber,
            @RequestParam String operator) {

        double result;

        switch (operator) {
            case "Cộng":
                result = firstNumber + secondNumber;
                break;
            case "Trừ":
                result = firstNumber - secondNumber;
                break;
            case "Nhân":
                result = firstNumber * secondNumber;
                break;
            case "Chia":
                if (secondNumber == 0) {
                    return "Lỗi: Không thể chia cho 0";
                }
                result = (double) firstNumber / secondNumber;
                break;
            default:
                return "Lỗi: Phép toán không hợp lệ";
        }

        return "Kết quả: " + result;
    }
}