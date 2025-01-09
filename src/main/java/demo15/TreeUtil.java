package demo15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/1  21:17
 */
public class TreeUtil {
    public static <T> List<Tree<T>> build(List<Metadata> metadataList, T rootId, TreeBuilder<Metadata, Tree<T>> builder) {
        Map<T, Tree<T>> nodeMap = new HashMap<>();
        List<Tree<T>> rootNodes = new ArrayList<>();

        // Build all nodes
        for (Metadata metadata : metadataList) {
            Tree<T> treeNode = new Tree<>();
            builder.build(metadata, treeNode);
            nodeMap.put(treeNode.getId(), treeNode);
        }

        // Build the tree structure
        for (Tree<T> treeNode : nodeMap.values()) {
            if (treeNode.getParentId().equals(rootId)) {
                rootNodes.add(treeNode);
            } else {
                Tree<T> parent = nodeMap.get(treeNode.getParentId());
                if (parent != null) {
                    parent.getChildren().add(treeNode);
                }
            }
        }

        return rootNodes;
    }

    interface TreeBuilder<T, U> {
        void build(T t, U u);
    }
}
