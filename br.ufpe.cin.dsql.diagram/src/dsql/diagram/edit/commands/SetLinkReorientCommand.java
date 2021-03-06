/*
 * 
 */
package dsql.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import dsql.Query;
import dsql.QueryDiagram;
import dsql.SetLink;
import dsql.diagram.edit.policies.DsqlBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class SetLinkReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public SetLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof SetLink) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Query && newEnd instanceof Query)) {
			return false;
		}
		Query target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof QueryDiagram)) {
			return false;
		}
		QueryDiagram container = (QueryDiagram) getLink().eContainer();
		return DsqlBaseItemSemanticEditPolicy.getLinkConstraints().canExistSetLink_4001(container, getLink(),
				getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Query && newEnd instanceof Query)) {
			return false;
		}
		Query source = getLink().getSource();
		if (!(getLink().eContainer() instanceof QueryDiagram)) {
			return false;
		}
		QueryDiagram container = (QueryDiagram) getLink().eContainer();
		return DsqlBaseItemSemanticEditPolicy.getLinkConstraints().canExistSetLink_4001(container, getLink(), source,
				getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected SetLink getLink() {
		return (SetLink) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected Query getOldSource() {
		return (Query) oldEnd;
	}

	/**
	* @generated
	*/
	protected Query getNewSource() {
		return (Query) newEnd;
	}

	/**
	* @generated
	*/
	protected Query getOldTarget() {
		return (Query) oldEnd;
	}

	/**
	* @generated
	*/
	protected Query getNewTarget() {
		return (Query) newEnd;
	}
}
