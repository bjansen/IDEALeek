package com.plopiplop.leekwars.editor.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LSBlock extends AbstractBlock {
    private SpacingBuilder spacingBuilder;

    protected LSBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment,
                      SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();

        while (child != null) {
            if (!FormatterUtil.containsWhiteSpacesOnly(child) && child.getTextLength() > 0) {
                Block block = new LSBlock(child, Wrap.createWrap(WrapType.NONE, false), null, spacingBuilder);
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        if (myNode.getTreeParent().getElementType() == LSTypes.BLOCK && myNode.getElementType() != LSTypes.OP_LBRACE && myNode.getElementType() != LSTypes.OP_RBRACE) {
            return Indent.getNormalIndent();
        }

        return Indent.getNoneIndent();
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int newChildIndex) {
        if (myNode.getElementType() == LSTypes.BLOCK) {
            return new ChildAttributes(Indent.getNormalIndent(), getAlignment());
        } else {
            return new ChildAttributes(Indent.getNoneIndent(), getAlignment());
        }
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }
}