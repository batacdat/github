package com.sqc.academy;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictionaryController {
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            Map.entry("hello", "Xin chào"),
            Map.entry("apple", "quả táo"),
            Map.entry("banana", "quả chuối"),
            Map.entry("lemon", "quả chanh")
    );

    @GetMapping("/dictionary")
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String word) {
        // Xử lý từ nhập vào: loại bỏ khoảng trắng dư thừa và chuyển chữ hoa thành chữ thường
        String translation = dictionaryMap.get(word.trim().toLowerCase());
        // Nếu tìm thấy bản dịch trong từ điển, trả về kết quả với mã trạng thái 200 OK
        if (translation != null) {
            return ResponseEntity.ok(translation);
        }
        // Nếu không tìm thấy, trả về thông báo lỗi với mã trạng thái 404 Not Found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy từ này trong từ điển.");
    }
}