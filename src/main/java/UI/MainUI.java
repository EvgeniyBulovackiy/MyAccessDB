package UI;

import DAO.DAOManager;
import UI.TableModels.*;
import UI.Tables.AbstractTable;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame {

  private static JScrollPane panel = new JScrollPane();
  private static MainUI current;
  private static AbstractTable currentTable;
  private static JButton jButton1;
  private static JButton jButton2;
  private static boolean isUIinits = false;
  private ComboBoxUI jComboBox;
  private TreePanelUI tree;
  private JLabel label1;
  private JLabel label2;
  private JLabel label3;
  private Dimension size;


  public MainUI() throws HeadlessException {
    super("MyAccessDB");
    current = this;
    init();
  }


  private void init() {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    this.setBounds(
      ((int) ((double) (size.width) * 0.015)),
      ((int) ((double) (size.height) * 0.03)),
      ((int) ((double) (size.width) * 0.9)),
      ((int) ((double) (size.height) * 0.9)));
    this.setJMenuBar(new MenuUI());
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setVisible(true);
    new DAOManager();
    }

  public void initUI() {

    initComponents();

    if (!isUIinits){
      initLayout();
    }
  }

  private void initLayout() {
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().getLayout();
    getContentPane().setLayout(layout);
    size = this.getSize();

    layout.setHorizontalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)

        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(label3)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jComboBox,
                (int) ((double) size.width * 0.15),
                (int) ((double) size.width * 0.15),
                (int) ((double) size.width * 0.15))
              .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(label1,
                  (int) ((double) size.width * 0.2),
                  (int) ((double) size.width * 0.2),
                  (int) ((double) size.width * 0.2))
                .addComponent(tree,
                  (int) ((double) size.width * 0.2),
                  (int) ((double) size.width * 0.2),
                  (int) ((double) size.width * 0.2)))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(label2,
                    (int) ((double) size.width * 0.6),
                    (int) ((double) size.width * 0.6), Short.MAX_VALUE)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(
                    jButton1,
                    (int) ((double) size.width * 0.1),
                    (int) ((double) size.width * 0.1),
                    (int) ((double) size.width * 0.1))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(
                    jButton2,
                    (int) ((double) size.width * 0.1),
                    (int) ((double) size.width * 0.1),
                    (int) ((double) size.width * 0.1)))
                .addComponent(panel,
                  (int) ((double) size.width * 0.6),
                  (int) ((double) size.width * 0.6), Short.MAX_VALUE))))
          .addContainerGap())
    );

    layout.setVerticalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(label3)
            .addComponent(jComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
            .addComponent(label2)
            .addComponent(jButton1)
            .addComponent(jButton2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tree, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
          .addContainerGap())
    );
    isUIinits = true;
    pack();
  }

  public void initComponents() {
    jComboBox = new ComboBoxUI();
    tree = new TreePanelUI();
    label1 = new JLabel("Все контейнеры");
    label2 = new JLabel("Содержимое");
    label3 = new JLabel("Таблица");

    jButton1 = new JButton("Добавить");
    jButton1.setEnabled(false);
    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        TableModel model = currentTable.getModel();

        switch (model.getClass().getSimpleName()){
          case "CDataTableModel":
            ((CDataTableModel)model).addRow();
            break;
          case "UDataTableModel":
            ((UDataTableModel)model).addRow();
            break;
          case "CQueueTableModel":
            ((CQueueTableModel)model).addRow();
            break;
          case "FDataTableModel":
            ((FDataTableModel)model).addRow();
            break;
          case "FQueueTableModel":
            ((FQueueTableModel)model).addRow();
            break;
        }
      }
    });

    jButton2 = new JButton("Удалить");
    jButton2.setEnabled(false);
    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        TableModel model = currentTable.getModel();

        switch (model.getClass().getSimpleName()){
          case "CDataTableModel":
            ((CDataTableModel)model).deleteRow(currentTable.getSelectedRow());
            break;
          case "UDataTableModel":
            ((UDataTableModel)model).deleteRow(currentTable.getSelectedRow());
            break;
          case "CQueueTableModel":
            ((CQueueTableModel)model).deleteRow(currentTable.getSelectedRow());
            break;
          case "FDataTableModel":
            ((FDataTableModel)model).deleteRow(currentTable.getSelectedRow());
            break;
          case "FQueueTableModel":
            ((FQueueTableModel)model).deleteRow(currentTable.getSelectedRow());
            break;
        }
      }
    });
  }

  public void setTableUI(AbstractTable table) {
    jButton1.setEnabled(true);
    jButton2.setEnabled(true);
    currentTable = table;
    panel.setViewportView(table);
  }

  public static MainUI getCurrentUI() {
    return current;
  }
}
