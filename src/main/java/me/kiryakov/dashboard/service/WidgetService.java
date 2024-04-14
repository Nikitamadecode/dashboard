package me.kiryakov.dashboard.service;

import me.kiryakov.dashboard.domain.Widget;
import me.kiryakov.dashboard.dto.WidgetDTO;
import me.kiryakov.dashboard.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {
    @Autowired
    private WidgetRepository widgetRepository;

    public WidgetDTO addWidget(WidgetDTO widgetDTO) {
        Widget widget = new Widget();

        widget.setY(widgetDTO.getX());
        widget.setX(widgetDTO.getY());
        widget.setHeight(widgetDTO.getHeight());
        widget.setWidth(widgetDTO.getWidth());
        widget.setType(widgetDTO.getType());
        widget = widgetRepository.save(widget);
        return new WidgetDTO(widget.getId(), widget.getX(), widget.getY(), widget.getHeight(), widget.getWidth(), widget.getType());
    }

    public List<WidgetDTO> widgetList() {
        List<Widget> allWidgets = widgetRepository.findAll();
        List<WidgetDTO> dtos = new ArrayList<WidgetDTO>();
        for (Widget widget : allWidgets) {
            WidgetDTO dto = new WidgetDTO();
            dto.setId(widget.getId());
            dto.setHeight(widget.getHeight());
            dto.setWidth(widget.getWidth());
            dto.setX(widget.getX());
            dto.setY(widget.getY());
            dto.setType(widget.getType());
            dtos.add(dto);
        }
        return dtos;
    }

    public WidgetDTO updateWidget(Integer id, WidgetDTO widgetDTO){
        Widget widget = widgetRepository.getById(id);
        widget.setX(widgetDTO.getX());
        widget.setY(widgetDTO.getY());
        widget.setWidth(widgetDTO.getWidth());
        widget.setType(widgetDTO.getType());
        widget = widgetRepository.save(widget);
        return new WidgetDTO(widget.getId(), widget.getX(), widget.getY(), widget.getHeight(), widget.getWidth(), widget.getType());
    }

    public void deleteById(Integer id){
        Widget widget = widgetRepository.getById(id);
        widgetRepository.delete(widget);
    }
}
