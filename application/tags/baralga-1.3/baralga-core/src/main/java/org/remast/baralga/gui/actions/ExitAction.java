package org.remast.baralga.gui.actions;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.remast.baralga.Messages;
import org.remast.baralga.gui.model.PresentationModel;

/**
 * Action to exit the application.
 * @author remast
 */
@SuppressWarnings("serial") //$NON-NLS-1$
public class ExitAction extends AbstractBaralgaAction {

    public ExitAction(final Frame owner, final PresentationModel model) {
        super(model);

        putValue(NAME, Messages.getString("ExitAction.Name")); //$NON-NLS-1$
        putValue(SHORT_DESCRIPTION, Messages.getString("ExitAction.ShortDescription")); //$NON-NLS-1$
        putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/icons/gtk-quit.png"))); //$NON-NLS-1$
        putValue(LONG_DESCRIPTION, Messages.getString("ExitAction.LongDescription")); //$NON-NLS-1$
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent event) {
        boolean quit = true;

        // If activity is running, then double check with user.
        if (getModel().isActive()) {
            final int dialogResult = JOptionPane.showConfirmDialog(
                    getOwner(), 
                    Messages.getString("ExitConfirmDialog.Message"),  //$NON-NLS-1$
                    Messages.getString("ExitConfirmDialog.Title"),  //$NON-NLS-1$
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            quit = JOptionPane.YES_OPTION == dialogResult;
        } 

        if (quit) {
            System.exit(0);
        }
    }

}