import java.util.ArrayList;

public class PrintPathEasy {
    ArrayList<String> locations = new ArrayList<String>();
    private int vertices;

    PrintPathEasy(Graph graph) {
        vertices = graph.getVertices();
        locations.add("ubc");
        locations.add("allison rd");
        locations.add("sasamat st");
        locations.add("alma st");
        locations.add("macdonald st");
        locations.add("arbutus st");
        locations.add("granville st");
        locations.add("willow st");
        locations.add("broadway city hall change");
        locations.add("main st");
        locations.add("frasaer st");
        locations.add("clark dr");
        locations.add("vcc clark");
        locations.add("commercial broadway change");
        locations.add("renfrew");
        locations.add("rupert");
        locations.add("gilmore");
        locations.add("brentwood town centre");
        locations.add("holdom");
        locations.add("sperling burnaby lake");
        locations.add("lake city way");
        locations.add("production way university");
        locations.add("lougheed town centre");
        locations.add("burquitlam");
        locations.add("moody centre");
        locations.add("inlet centre");
        locations.add("linclon");
        locations.add("burrard change");
        locations.add("granville station");
        locations.add("cambie st");
        locations.add("main street");
        locations.add("commercial dr");
        locations.add("nanaimo st");
        locations.add("renfrew st");
        locations.add("kootenay loop");
        locations.add("gilmore ave");
        locations.add("willingdon ave");
        locations.add("hythe ave");
        locations.add("holdom ave");
        locations.add("kensington ave");
        locations.add("duthie ave");
        locations.add("sfu transportation");
        locations.add("richmond brighouse");
        locations.add("lansdowne");
        locations.add("aberdeen");
        locations.add("bridgeport");
        locations.add("marine drive");
        locations.add("langara 49th avenue");
        locations.add("oakridge 41st avenue");
        locations.add("king edward");
        locations.add("olympic village");
        locations.add("yaletown roundhouse");
        locations.add("vancouver city centre");
        locations.add("king george change");
        locations.add("surrey central change");
        locations.add("gateway");
        locations.add("scott road");
        locations.add("columbia change");
        locations.add("sapperton");
        locations.add("braid");
        locations.add("new westminster");
        locations.add("22nd street");
        locations.add("edmonds");
        locations.add("royal oak");
        locations.add("metrotown");
        locations.add("patterson");
        locations.add("joyce collingwood");
        locations.add("29th avenue");
        locations.add("nanaimo");
        locations.add("main street science world");
        locations.add("stadium chinatown");
        locations.add("granville");
        locations.add("newton exchange");
        locations.add("76th ave");
        locations.add("80th ave");
        locations.add("88th ave");
        locations.add("whalley blvd");
        locations.add("140th st");
        locations.add("144th st");
        locations.add("148th st");
        locations.add("port coquitiam");
        locations.add("coquitiam central");
        locations.add("waterfront change");
        locations.add("lafarge lake douglas");
        locations.add("sfu");
        locations.add("guildford exchange");
        locations.add("96th ave");
        locations.add("commercial broadway orange");
        locations.add("commercial broadway yellow");
        locations.add("broadway city hall orange");
        locations.add("broadway city hall blue");
        locations.add("burrard orange");
        locations.add("burrard blue");
        locations.add("waterfront skyblue");
        locations.add("waterfront blue");
        locations.add("waterfront purple");
        locations.add("king george blue");
        locations.add("king george orange");
        locations.add("surrey central blue");
        locations.add("surrey central orange");
        locations.add("columbia1");
        locations.add("columbia2");
        locations.add("columbia3");
        locations.add("lougheed town centre yellow");
        locations.add("lougheed town centre blue");
        locations.add("commercial broadway blue");
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getLocationIndex(String location) {
        return locations.indexOf(location);
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }

    public void printPath(int[] parent, int[] distance, int source, int destination) {
        System.out.println("Source: " + locations.get(source) + " To " + "Destination: " + locations.get(destination));
        System.out.print("Path: ");
        printHelper(parent, source, destination);
        System.out.println();
    }

    private void printHelper(int parent[], int source, int destination) {
        if (parent[destination] == -1) {
            System.out.print(locations.get(source));
            return;
        }
        printHelper(parent, source, parent[destination]);
        System.out.print("-->" + locations.get(destination));
    }
}
