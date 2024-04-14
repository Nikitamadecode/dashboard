package me.kiryakov.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.kiryakov.dashboard.domain.WidgetType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WidgetDTO {

    private Integer id;

    private Integer x;

    private Integer y;

    private Integer width;

    private Integer height;

    private WidgetType type;
}
