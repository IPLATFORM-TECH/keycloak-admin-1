package space.eliseev.keycloakadmin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import space.eliseev.keycloakadmin.entity.User;

@Route
public class MainView extends VerticalLayout {


    public MainView() {
        Grid<User> grid = new Grid<>(User.class);
        TextField field = new TextField();
        Button someBtn = new Button("This is a test button", VaadinIcon.MOON.create());
        field.setPlaceholder("This is a test page");
        HorizontalLayout actions = new HorizontalLayout(field, someBtn);
        add(actions, new H2("This is a test table"), grid);
        grid.setHeight("200px");
        grid.setColumns("id", "firstName", "lastName", "username", "createdTimestamp", "enabled");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

    }

}
