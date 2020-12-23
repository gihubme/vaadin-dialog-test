package org.nnn4eu.testdialog.ui;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import lombok.extern.slf4j.Slf4j;

@Tag("my-confirm-dialog1")
@Slf4j
// @Getter
// @Setter
public class MyConfirmDialogB extends Dialog  { //implements HasStyle
  //HasOrderedComponents<MyConfirmDialog>//to replace elements keeping the same position

  private Label title;
  private Label question;
  private Button confirm;

  public MyConfirmDialogB() {
		createHeader();
    createContent();
    createFooter();
  }

  public MyConfirmDialogB(String title, String content, ComponentEventListener listener) {
		this();
		setTitle(title);
		setQuestion(content);
		addConfirmationListener(listener);
	}

  public void setTitle(String title) {
    this.title.setText(title);
  }

  public void setQuestion(String question) {
    this.question.setText(question);
  }

  public void addConfirmationListener(ComponentEventListener listener) {
    confirm.addClickListener(listener);
  }

  private void createHeader() {
    this.title = new Label();
    Button close = new Button();
    close.setIcon(VaadinIcon.CLOSE.create());
    close.addClickListener(buttonClickEvent -> close());

    HorizontalLayout header = new HorizontalLayout();
    header.add(this.title, close);
    header.setFlexGrow(1, this.title);
    header.setAlignItems(FlexComponent.Alignment.CENTER);
    header.getStyle().set("background-color", "green");
    add(header);
  }
  
  private void createContent() {
    question = new Label();

    VerticalLayout content = new VerticalLayout();
    content.add(question);
    content.setPadding(false);
    content.getStyle().set("background-color", "red");
    add(content);
  }

  private void createFooter() {
    Button abort = new Button("Abort");
    abort.addClickListener(buttonClickEvent -> close());
    confirm = new Button("Confirm");
    confirm.addClickListener(buttonClickEvent -> close());

    HorizontalLayout footer = new HorizontalLayout();
    footer.add(abort, confirm);
    footer.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
    footer.getStyle().set("background-color", "yellow");
    add(footer);
  }

}
