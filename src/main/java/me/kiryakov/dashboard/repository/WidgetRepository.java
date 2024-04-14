package me.kiryakov.dashboard.repository;

import me.kiryakov.dashboard.domain.Widget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetRepository extends JpaRepository<Widget, Integer> {
}
