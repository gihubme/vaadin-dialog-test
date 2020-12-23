package org.nnn4eu.testdialog.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Theme(value = Lumo.class)
@PropertySource(value = { "classpath:application.properties" }, ignoreResourceNotFound = false)
public class MainView extends VerticalLayout implements RouterLayout {

    @Getter @Setter
    private Div content = new Div();
    private final Tabs menu = new Tabs();
    // private final MyConfirmDialog confirmDialog = new MyConfirmDialog();

    @PostConstruct
    void init() {

        menu.add(getAvailableTabs());
        menu.setFlexGrowForEnclosedTabs(1);
        menu.setSelectedIndex(0);
        menu.setAutoselect(true);
        add(menu, content);
        addClassName("main-view");

    }

    public MainView() {

        // Notification.show
        content.setId("m-app-content");
        content.setWidthFull();
        content.getStyle().set("margin", "auto");
        

        menu.setId("m-top-nav");
        menu.setOrientation(Tabs.Orientation.HORIZONTAL);
        menu.setWidthFull();


        // Router route = UI.getCurrent().getRouter();
        // RouteConfiguration rocon = RouteConfiguration.forSessionScope();
        // RouteConfiguration routeConfiguration = RouteConfiguration.forApplicationScope();
        // String url = routeConfiguration.getUrl(TestView1.class);

    }


    private Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>();

        tabs.add(createTab(VaadinIcon.EDIT, "MyView Title", MyView.class));
        return tabs.toArray(new Tab[tabs.size()]);
    }

    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
    }

    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }

    @Override
    public void showRouterLayoutContent(HasElement con) {
        if (con != null) {
            content.getElement()
                        .appendChild(Objects.requireNonNull(con.getElement()));
        }
    }
}
