package demo15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/1  21:18
 */
public class MetadataTreeDemo {

    public static List<Tree<Long>> getModelTree(List<Metadata> metadataList) {
        return TreeUtil.build(metadataList, 0L, (metadata, treeNode) -> {
            treeNode.setId(metadata.getElementId());
            treeNode.setParentId(metadata.getElementPid());
            treeNode.setName(metadata.getMetadataName());
            treeNode.setWeight(metadata.getSortNum());
            treeNode.putExtra("RESTRICT_FLAG", metadata.getRestrictFlag());
            treeNode.putExtra("METADATA_PARAM", metadata.getMetadataParam());
            treeNode.putExtra("DATA_TYPE", metadata.getDataType());
            treeNode.putExtra("DATA_LENGTH", metadata.getDataLength());
            treeNode.putExtra("CHECK_SCRIPT", metadata.getCheckScript());
        });
    }

    public static void printTreeNode(Tree<Long> node, String indent) {
        System.out.println(indent + "ID: " + node.getId() + ", Name: " + node.getName());
        if (!node.getChildren().isEmpty()) {
            System.out.println("儿子节点》》》》》》》》》》");
        for (Tree<Long> child : node.getChildren()) {
            printTreeNode(child, indent + "  ");
        }
    }}

    public static void main(String[] args) {
        // Create a list of Metadata objects
        List<Metadata> metadataList = new ArrayList<>();
        metadataList.add(new Metadata(1L, 0L, "公司", 1, "A", "param1", "String", 10, "check1"));
        metadataList.add(new Metadata(2L, 1L, "财务部", 2, "B", "param2", "String", 10, "check2"));
        metadataList.add(new Metadata(3L, 1L, "研发部", 3, "C", "param3", "String", 10, "check3"));
        metadataList.add(new Metadata(4L, 3L, "后端组", 4, "D", "param4", "String", 10, "check4"));
        metadataList.add(new Metadata(5L, 3L, "前端组", 5, "E", "param5", "String", 10, "check5"));

        // Build the tree
        List<Tree<Long>> modelTree = getModelTree(metadataList);

        // Print the tree
        for (Tree<Long> rootNode : modelTree) {
            printTreeNode(rootNode, "");
        }
    }
}
