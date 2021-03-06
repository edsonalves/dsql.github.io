/*
 * 
 */
package dsql.diagram.edit.parts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import dsql.Column;
import dsql.ColumnType;
import dsql.diagram.edit.policies.LogicalOperationItemSemanticEditPolicy;
import dsql.diagram.edit.policies.OpenDiagramEditPolicy;
import dsql.diagram.part.DsqlVisualIDRegistry;
import dsql.diagram.providers.DsqlElementTypes;

/**
 * @generated
 */
public class LogicalOperationEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2004;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public LogicalOperationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(DsqlVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LogicalOperationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy()); // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new LogicalOperationFigure();
	}

	/**
	 * @generated
	 */
	public LogicalOperationFigure getPrimaryShape() {
		return (LogicalOperationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LogicalOperationTypeEditPart) {
			((LogicalOperationTypeEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureLogicalOperationLabelFigure());
			return true;
		}
		if (childEditPart instanceof LogicalOperationLogicalOperationExpressionsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getLogicalOperationExpressionsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((LogicalOperationLogicalOperationExpressionsCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LogicalOperationTypeEditPart) {
			return true;
		}
		if (childEditPart instanceof LogicalOperationLogicalOperationExpressionsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getLogicalOperationExpressionsCompartmentFigure();
			pane.remove(((LogicalOperationLogicalOperationExpressionsCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof LogicalOperationLogicalOperationExpressionsCompartmentEditPart) {
			return getPrimaryShape().getLogicalOperationExpressionsCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated not
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40) {
			public PointList getPolygonPoints() {
				PointList points = new PointList(21);
				Rectangle r = getHandleBounds();

				Point p1 = new Point(r.x, r.y + r.height - 1);
				Point p2 = new Point(r.x, r.y);
				Point p3 = new Point(r.x + (r.width - 10), r.y);
				Point p4 = new Point(r.x + r.width - 1, r.y + 10);
				Point p5 = new Point(r.x + r.width - 1, r.y + r.height - 1);

				points.addPoint(p1);
				points.addPoint(p2);
				points.addPoint(p3);
				points.addPoint(p4);
				points.addPoint(p5);

				return points;
			}
		};
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(DsqlVisualIDRegistry.getType(LogicalOperationTypeEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == DsqlElementTypes.Column_3050) {
				return getChildBySemanticHint(DsqlVisualIDRegistry
						.getType(LogicalOperationLogicalOperationExpressionsCompartmentEditPart.VISUAL_ID));
			}
			if (type == DsqlElementTypes.Unary_3051) {
				return getChildBySemanticHint(DsqlVisualIDRegistry
						.getType(LogicalOperationLogicalOperationExpressionsCompartmentEditPart.VISUAL_ID));
			}
			if (type == DsqlElementTypes.Binary_3052) {
				return getChildBySemanticHint(DsqlVisualIDRegistry
						.getType(LogicalOperationLogicalOperationExpressionsCompartmentEditPart.VISUAL_ID));
			}
			if (type == DsqlElementTypes.Ternary_3053) {
				return getChildBySemanticHint(DsqlVisualIDRegistry
						.getType(LogicalOperationLogicalOperationExpressionsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class LogicalOperationFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLogicalOperationLabelFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fLogicalOperationExpressionsCompartmentFigure;

		/**
		 * @generated
		 */
		public LogicalOperationFigure() {
			this.setForegroundColor(THIS_FORE);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(3), getMapMode().DPtoLP(3),
					getMapMode().DPtoLP(3)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLogicalOperationLabelFigure = new WrappingLabel();

			fFigureLogicalOperationLabelFigure.setText("LogicalOperation");
			fFigureLogicalOperationLabelFigure
					.setMaximumSize(new Dimension(getMapMode().DPtoLP(10000), getMapMode().DPtoLP(50)));

			this.add(fFigureLogicalOperationLabelFigure);

			fLogicalOperationExpressionsCompartmentFigure = new RectangleFigure();

			fLogicalOperationExpressionsCompartmentFigure.setOutline(false);

			this.add(fLogicalOperationExpressionsCompartmentFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLogicalOperationLabelFigure() {
			return fFigureLogicalOperationLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getLogicalOperationExpressionsCompartmentFigure() {
			return fLogicalOperationExpressionsCompartmentFigure;
		}

		/**
		 * @generated not
		 */
		@Override
		protected void outlineShape(Graphics graphics) {

			Rectangle r = getBounds();

			Point p1 = new Point(r.x, r.y + r.height - 1);
			Point p2 = new Point(r.x, r.y);
			Point p3 = new Point(r.x + (r.width - 10), r.y);
			Point p4 = new Point(r.x + r.width - 1, r.y + 10);
			Point p5 = new Point(r.x + r.width - 1, r.y + r.height - 1);

			PointList pointList = new PointList();
			pointList.addPoint(p1);
			pointList.addPoint(p2);
			pointList.addPoint(p3);
			pointList.addPoint(p4);
			pointList.addPoint(p5);

			graphics.fillPolygon(pointList);

			graphics.drawLine(p1, p2);
			graphics.drawLine(p2, p3);
			graphics.drawLine(p3, p4);
			graphics.drawLine(p4, p5);
			graphics.drawLine(p5, p1);

			this.setLineWidth(1);
			this.setForegroundColor(new Color(null, 0, 0, 0));
		}
	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 0, 0, 0);

}
