package org.nnn4eu.testdialog.ui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Tag("my-view")
@Route(value = MyView.ROUTE, layout = MainView.class)
@PageTitle(MyView.TITLE)
public class MyView extends Composite<VerticalLayout> implements HasSize {
  public static final String ROUTE = "";
  public static final String TITLE = "MyView";

  public MyView() {
    getContent().add(new H3("My View"));

    MyConfirmDialogB dialog = new MyConfirmDialogB();
    dialog.setTitle("Confirm");
    dialog.setQuestion("Are you sure, you want to commit this action?");
    Button button = new Button("Open Dialog", event -> {
      Notification.show("hello, i should open dialog");
      dialog.open();
      });
    getContent().add(button);
    
  }
  

}
