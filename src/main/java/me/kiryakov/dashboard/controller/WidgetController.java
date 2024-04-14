package me.kiryakov.dashboard.controller;

import me.kiryakov.dashboard.dto.NoteDTO;
import me.kiryakov.dashboard.dto.WidgetDTO;
import me.kiryakov.dashboard.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/widgets")
public class WidgetController {

    @Autowired
    private WidgetService widgetService;

    @PostMapping("/")
    public ResponseEntity<WidgetDTO> add(@RequestBody WidgetDTO widgetDTO) {
        WidgetDTO dto = widgetService.addWidget(widgetDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/")
    public ResponseEntity<List<WidgetDTO>> getAll() {
        List<WidgetDTO> all = widgetService.widgetList();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WidgetDTO> update(@PathVariable Integer id, @RequestBody WidgetDTO widgetDTO) {
        WidgetDTO dto = widgetService.updateWidget(id, widgetDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        widgetService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
