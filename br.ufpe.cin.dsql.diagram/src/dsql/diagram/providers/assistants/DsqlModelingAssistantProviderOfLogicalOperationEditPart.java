/*
 * 
 */
package dsql.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dsql.diagram.edit.parts.LogicalOperationEditPart;
import dsql.diagram.providers.DsqlElementTypes;
import dsql.diagram.providers.DsqlModelingAssistantProvider;

/**
 * @generated
 */
public class DsqlModelingAssistantProviderOfLogicalOperationEditPart extends DsqlModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(DsqlElementTypes.Column_3050);
		types.add(DsqlElementTypes.Unary_3051);
		types.add(DsqlElementTypes.Binary_3052);
		types.add(DsqlElementTypes.Ternary_3053);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((LogicalOperationEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(LogicalOperationEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(DsqlElementTypes.LogicalLink_4005);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((LogicalOperationEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(LogicalOperationEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DsqlElementTypes.LogicalLink_4005) {
			types.add(DsqlElementTypes.Column_3001);
			types.add(DsqlElementTypes.Column_3002);
			types.add(DsqlElementTypes.Column_3004);
			types.add(DsqlElementTypes.Column_3007);
			types.add(DsqlElementTypes.Column_3008);
			types.add(DsqlElementTypes.Column_3011);
			types.add(DsqlElementTypes.Column_3012);
			types.add(DsqlElementTypes.Column_3013);
			types.add(DsqlElementTypes.Column_3033);
			types.add(DsqlElementTypes.Column_3037);
			types.add(DsqlElementTypes.Column_3038);
			types.add(DsqlElementTypes.Column_3039);
			types.add(DsqlElementTypes.Column_3050);
		}
		return types;
	}

}
