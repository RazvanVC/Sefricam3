package com.sefricam.sefricam3;

// AUTOGENERADO: Andalucía (Excel) + Madrid (derivado inverso con longitudes negativas)

import java.util.*;

/** Registro general de cuadrículas (embebido para Android, sin I/O).
 *  - Málaga y Huelva: extraídas de Excel (campos Denominacion, centrlat, centrlon).
 *  - Madrid: derivado de forma inversa desde setCuadricula(longitud, latitud) y ajustado a longitudes negativas (W).
 *  - Sin uso de Math.abs, se respetan signos ±.
 */
public final class GridRegistry {
    private GridRegistry() { }

    /** Representa una cuadrícula con nombre y centro (lat, lon) en grados. */
    public static record GridCell(String denominacion, double centrlat, double centrlon) { }

    /** Comunidad/ámbito para organizar grupos. */
    public enum Scope {
        ANDALUCIA_MALAGA, ANDALUCIA_HUELVA, MADRID, OTRA
    }

    public static final java.util.List<GridCell> MALAGA = java.util.List.of(
        new GridCell("01VF27", 36.81788592, -3.84091344),
        new GridCell("02VF26", 36.72774789, -3.83992950),
        new GridCell("03VF17", 36.81704024, -3.95302198),
        new GridCell("04VF16", 36.72690496, -3.95190691),
        new GridCell("05VF08", 36.90621966, -4.06637727),
        new GridCell("06VF07", 36.81608888, -4.06512555),
        new GridCell("07VF06", 36.72595671, -4.06387937),
        new GridCell("08UF98", 36.90515920, -4.17860696),
        new GridCell("09UF97", 36.81503188, -4.17722356),
        new GridCell("10UF96", 36.72490314, -4.17584630),
        new GridCell("11UG80", 37.08423556, -4.29388083),
        new GridCell("12UF89", 36.99411488, -4.29235226),
        new GridCell("13UF88", 36.90399277, -4.29083047),
        new GridCell("14UF87", 36.81386924, -4.28931544),
        new GridCell("15UF86", 36.72374429, -4.28780713),
        new GridCell("16UG72", 37.26318361, -4.40970752),
        new GridCell("17UG71", 37.17306996, -4.40803132),
        new GridCell("18UG70", 37.08295487, -4.40636256),
        new GridCell("19UF79", 36.99283834, -4.40470121),
        new GridCell("20UF78", 36.90272038, -4.40304723),
        new GridCell("21UF77", 36.81260099, -4.40140059),
        new GridCell("22UF76", 36.72248017, -4.39976126),
        new GridCell("23UF75", 36.63235791, -4.39812919),
        new GridCell("24UG61", 37.17167812, -4.52063899),
        new GridCell("25UG60", 37.08156755, -4.51883690),
        new GridCell("26UF69", 36.99145552, -4.51704280),
        new GridCell("27UF68", 36.90134206, -4.51525666),
        new GridCell("28UF67", 36.81122715, -4.51347845),
        new GridCell("29UF66", 36.72111079, -4.51170812),
        new GridCell("30UF65", 36.63099300, -4.50994565),
        new GridCell("31UF64", 36.54087376, -4.50819099),
        new GridCell("32UG51", 37.17017933, -4.63323863),
        new GridCell("33UG50", 37.08007362, -4.63130323),
        new GridCell("34UF59", 36.98996644, -4.62937642),
        new GridCell("35UF58", 36.89985781, -4.62745816),
        new GridCell("36UF57", 36.80974773, -4.62554841),
        new GridCell("37UF56", 36.71963619, -4.62364713),
        new GridCell("38UF55", 36.62952320, -4.62175429),
        new GridCell("39UF54", 36.53940876, -4.61986983),
        new GridCell("40UG41", 37.16857362, -4.74582963),
        new GridCell("41UG40", 37.07847311, -4.74376097),
        new GridCell("42UF49", 36.98837113, -4.74170149),
        new GridCell("43UF48", 36.89826768, -4.73965115),
        new GridCell("44UF47", 36.80816277, -4.73760990),
        new GridCell("45UF46", 36.71805638, -4.73557771),
        new GridCell("46UF45", 36.62794854, -4.73355453),
        new GridCell("47UF44", 36.53783923, -4.73154032),
        new GridCell("48UF43", 36.44772847, -4.72953504),
        new GridCell("49UG31", 37.16686100, -4.85841141),
        new GridCell("50UG30", 37.07676604, -4.85620954),
        new GridCell("51UF39", 36.98666960, -4.85401743),
        new GridCell("52UF38", 36.89657168, -4.85183505),
        new GridCell("53UF37", 36.80647228, -4.84966234),
        new GridCell("54UF36", 36.71637140, -4.84749928),
        new GridCell("55UF35", 36.62626905, -4.84534580),
        new GridCell("56UF34", 36.53616522, -4.84320188),
        new GridCell("57UG20", 37.07495245, -4.96864833),
        new GridCell("58UF29", 36.98486189, -4.96632364),
        new GridCell("59UF28", 36.89476984, -4.96400926),
        new GridCell("60UF27", 36.80467630, -4.96170515),
        new GridCell("61UF26", 36.71458127, -4.95941125),
        new GridCell("62UF25", 36.62448474, -4.95712753),
        new GridCell("63UF24", 36.53438673, -4.95485393),
        new GridCell("64UF23", 36.44428723, -4.95259041),
        new GridCell("65UF19", 36.98294803, -5.07861954),
        new GridCell("66UF18", 36.89286220, -5.07617321),
        new GridCell("67UF17", 36.80277486, -5.07373774),
        new GridCell("68UF16", 36.71268601, -5.07131306),
        new GridCell("69UF15", 36.62259566, -5.06889913),
        new GridCell("70UF14", 36.53250381, -5.06649591),
        new GridCell("71UF13", 36.44241045, -5.06410334),
        new GridCell("72UF07", 36.80076798, -5.18575952),
        new GridCell("73UF06", 36.71068566, -5.18320411),
        new GridCell("74UF05", 36.62060183, -5.18066003),
        new GridCell("75UF04", 36.53051648, -5.17812723),
        new GridCell("76UF03", 36.44042961, -5.17560566),
        new GridCell("77TF97", 36.79865571, -5.29776993),
        new GridCell("78TF96", 36.70858026, -5.29508384),
        new GridCell("79TF95", 36.61850328, -5.29240966),
        new GridCell("80TF94", 36.52842477, -5.28974733),
        new GridCell("81TF93", 36.43834473, -5.28709680),
        new GridCell("82TF93", 36.43834473, -5.28709680),
        new GridCell("83TF85", 36.61630005, -5.40414743),
        new GridCell("84TF84", 36.52622873, -5.40135563)
    );

    public static final java.util.List<GridCell> HUELVA = java.util.List.of(
        new GridCell("01QB49", 37.86681824, -5.89887338),
        new GridCell("02QB48", 37.77680200, -5.89535180),
        new GridCell("03QC30", 37.95397099, -6.01608827),
        new GridCell("04QB39", 37.86396562, -6.01241293),
        new GridCell("05QB38", 37.77395856, -6.00875391),
        new GridCell("06QB34", 37.41391356, -5.99427962),
        new GridCell("07QB32", 37.23388104, -5.98713847),
        new GridCell("08QB31", 37.14386228, -5.98359163),
        new GridCell("09QB30", 37.05384187, -5.98006052),
        new GridCell("10QA39", 36.96381980, -5.97654507),
        new GridCell("11QA38", 36.87379607, -5.97304520),
        new GridCell("12QA37", 36.78377070, -5.96956084),
        new GridCell("13QC20", 37.95099954, -6.12974945),
        new GridCell("14QB29", 37.86100371, -6.12593614),
        new GridCell("15QB28", 37.77100618, -6.12213977),
        new GridCell("16QB26", 37.59100602, -6.11459754),
        new GridCell("17QB25", 37.50100340, -6.11085151),
        new GridCell("18QB24", 37.41099908, -6.10712211),
        new GridCell("19QB23", 37.32099307, -6.10340926),
        new GridCell("20QB22", 37.23098537, -6.09971288),
        new GridCell("21QB21", 37.14097599, -6.09603289),
        new GridCell("22QB20", 37.05096493, -6.09236921),
        new GridCell("23QA29", 36.96095219, -6.08872178),
        new GridCell("24QA28", 36.87093777, -6.08509051),
        new GridCell("25QC10", 37.94791850, -6.24339361),
        new GridCell("26QB19", 37.85793258, -6.23944242),
        new GridCell("27QB18", 37.76794493, -6.23550877),
        new GridCell("28QB17", 37.67795556, -6.23159260),
        new GridCell("29QB16", 37.58796446, -6.22769381),
        new GridCell("30QB15", 37.49797165, -6.22381233),
        new GridCell("31QB14", 37.40797711, -6.21994807),
        new GridCell("32QB13", 37.31798087, -6.21610095),
        new GridCell("33QB12", 37.22798291, -6.21227089),
        new GridCell("34QB11", 37.13798325, -6.20845782),
        new GridCell("35QB10", 37.04798189, -6.20466166),
        new GridCell("36QA19", 36.95797882, -6.20088232),
        new GridCell("37QC01", 38.03470185, -6.36112738),
        new GridCell("38QC00", 37.94472794, -6.35702013),
        new GridCell("39QB09", 37.85475227, -6.35293114),
        new GridCell("40QB08", 37.76477485, -6.34886030),
        new GridCell("41QB07", 37.67479568, -6.34480755),
        new GridCell("42QB06", 37.58481477, -6.34077278),
        new GridCell("43QB05", 37.49483211, -6.33675592),
        new GridCell("44QB04", 37.40484772, -6.33275688),
        new GridCell("45QB03", 37.31486158, -6.32877557),
        new GridCell("46QB02", 37.22487371, -6.32481193),
        new GridCell("47QB01", 37.13488411, -6.32086586),
        new GridCell("48QB00", 37.04489279, -6.31693728),
        new GridCell("49PC91", 38.03139117, -6.47487398),
        new GridCell("50PC90", 37.94142789, -6.47062841),
        new GridCell("51PB99", 37.85146283, -6.46640170),
        new GridCell("52PB98", 37.76149600, -6.46219376),
        new GridCell("53PB97", 37.67152738, -6.45800450),
        new GridCell("54PB96", 37.58155700, -6.45383384),
        new GridCell("55PB95", 37.49158485, -6.44968168),
        new GridCell("56PB94", 37.40161093, -6.44554795),
        new GridCell("57PB92", 37.22165782, -6.43733539),
        new GridCell("58PB92", 37.22165782, -6.43733539),
        new GridCell("59PB91", 37.13167863, -6.43325640),
        new GridCell("60PB90", 37.04169768, -6.42919549),
        new GridCell("61PC82", 38.11792121, -6.59300500),
        new GridCell("62PC81", 38.02797072, -6.58860163),
        new GridCell("63PC80", 37.93801843, -6.58421783),
        new GridCell("64PB89", 37.84806433, -6.57985349),
        new GridCell("65PB88", 37.75810842, -6.57550853),
        new GridCell("66PB87", 37.66815071, -6.57118287),
        new GridCell("67PB86", 37.57819121, -6.56687640),
        new GridCell("68PB85", 37.48822991, -6.56258903),
        new GridCell("69PB84", 37.39826682, -6.55832068),
        new GridCell("70PB83", 37.30830194, -6.55407126),
        new GridCell("71PB82", 37.21833529, -6.54984069),
        new GridCell("72PB81", 37.12836685, -6.54562886),
        new GridCell("73PC70", 37.93449960, -6.69778777),
        new GridCell("74PB79", 37.84455680, -6.69328590),
        new GridCell("75PB78", 37.75461218, -6.68880402),
        new GridCell("76PB77", 37.66466572, -6.68434203),
        new GridCell("77PB76", 37.57471745, -6.67989984),
        new GridCell("78PB75", 37.48476735, -6.67547736),
        new GridCell("79PB74", 37.39481543, -6.67107449),
        new GridCell("80PB73", 37.30486171, -6.66669115),
        new GridCell("81PB72", 37.21490617, -6.66232723),
        new GridCell("82PB71", 37.12494882, -6.65798266),
        new GridCell("83PC60", 37.93087146, -6.81133763),
        new GridCell("84PB69", 37.84094032, -6.80669833),
        new GridCell("85PB68", 37.75100733, -6.80207962),
        new GridCell("86PB67", 37.66107248, -6.79748140),
        new GridCell("87PB66", 37.57113577, -6.79290359),
        new GridCell("88PB65", 37.48119722, -6.78834608),
        new GridCell("89PB64", 37.39125683, -6.78380878),
        new GridCell("90PB63", 37.30131459, -6.77929159),
        new GridCell("91PB63", 37.30131459, -6.77929159),
        new GridCell("92PB61", 37.12142462, -6.77031720),
        new GridCell("93PC50", 37.92713408, -6.92486681),
        new GridCell("94PB59", 37.83721495, -6.92009016),
        new GridCell("95PB58", 37.74729393, -6.91533471),
        new GridCell("96PB57", 37.65737103, -6.91060037),
        new GridCell("97PB56", 37.56744625, -6.90588702),
        new GridCell("98PB55", 37.47751959, -6.90119458),
        new GridCell("99PB54", 37.38759106, -6.89652295),
        new GridCell("100PB53", 37.29766067, -6.89187202),
        new GridCell("101PB52", 37.20772841, -6.88724171),
        new GridCell("102PB51", 37.11779429, -6.88263191),
        new GridCell("103PB48", 37.74347205, -7.02856871),
        new GridCell("104PB47", 37.65356145, -7.02369833),
        new GridCell("105PB46", 37.56364893, -7.01884956),
        new GridCell("106PB45", 37.47373452, -7.01402228),
        new GridCell("107PB44", 37.38381820, -7.00921641),
        new GridCell("108PB43", 37.29389999, -7.00443184),
        new GridCell("109PB42", 37.20397988, -6.99966847),
        new GridCell("110PB41", 37.11405788, -6.99492620),
        new GridCell("111PB36", 37.55974389, -7.13179059),
        new GridCell("112PB35", 37.46984206, -7.12682858)
    );

    public static final java.util.List<GridCell> MADRID = java.util.List.of(
        new GridCell("01UKA10", 40.60305455, -4.22405000),
        new GridCell("02UKB10", 40.51426501, -4.22405000),
        new GridCell("03UKC09", 40.42547547, -4.33995000),
        new GridCell("04UKC10", 40.42547547, -4.22405000),
        new GridCell("05UKD08", 41.22458133, -3.29685000),
        new GridCell("06UKD09", 40.33668593, -4.33995000),
        new GridCell("07UKD10", 40.33668593, -4.22405000),
        new GridCell("08UKE08", 41.13579179, -3.29685000),
        new GridCell("09UKE09", 40.24789639, -4.33995000),
        new GridCell("10VLE06", 41.13579179, -3.52865000),
        new GridCell("11VLF05", 41.04700225, -3.64455000),
        new GridCell("12VLF06", 41.04700225, -3.52865000),
        new GridCell("13VLF07", 41.04700225, -3.41275000),
        new GridCell("14VLG03", 40.95821271, -3.87635000),
        new GridCell("15VLG04", 40.95821271, -3.76045000),
        new GridCell("16VLG05", 40.95821271, -3.64455000),
        new GridCell("17VLG06", 40.95821271, -3.52865000),
        new GridCell("18VLG07", 40.95821271, -3.41275000),
        new GridCell("19VLH03", 40.86942317, -3.87635000),
        new GridCell("20VLH04", 40.86942317, -3.76045000),
        new GridCell("21VLH05", 40.86942317, -3.64455000),
        new GridCell("22VLH06", 40.86942317, -3.52865000),
        new GridCell("23VLI02", 40.78063363, -3.99225000),
        new GridCell("24VLI03", 40.78063363, -3.87635000),
        new GridCell("25VLI04", 40.78063363, -3.76045000),
        new GridCell("26VLI05", 40.78063363, -3.64455000),
        new GridCell("27VLI06", 40.78063363, -3.52865000),
        new GridCell("28VLJ01", 40.69184409, -4.10815000),
        new GridCell("29VLJ02", 40.69184409, -3.99225000),
        new GridCell("30VLJ03", 40.69184409, -3.87635000),
        new GridCell("31VLJ04", 40.69184409, -3.76045000),
        new GridCell("32VLJ05", 40.69184409, -3.64455000),
        new GridCell("33VLJ06", 40.69184409, -3.52865000),
        new GridCell("34VKA01", 40.60305455, -4.10815000),
        new GridCell("35VKA02", 40.60305455, -3.99225000),
        new GridCell("36VKA03", 40.60305455, -3.87635000),
        new GridCell("37VKA04", 40.60305455, -3.76045000),
        new GridCell("38VKA05", 40.60305455, -3.64455000),
        new GridCell("39VKA06", 40.60305455, -3.52865000),
        new GridCell("40VKA07", 40.60305455, -3.41275000),
        new GridCell("41VKB01", 40.51426501, -4.10815000),
        new GridCell("42VKB02", 40.51426501, -3.99225000),
        new GridCell("43VKB03", 40.51426501, -3.87635000),
        new GridCell("44VKB04", 40.51426501, -3.76045000),
        new GridCell("45VKB05", 40.51426501, -3.64455000),
        new GridCell("46VKB06", 40.51426501, -3.52865000),
        new GridCell("47VKB07", 40.51426501, -3.41275000),
        new GridCell("48VKB08", 40.51426501, -3.29685000),
        new GridCell("49VKC01", 40.42547547, -4.10815000),
        new GridCell("50VKC02", 40.42547547, -3.99225000),
        new GridCell("51VKC03", 40.42547547, -3.87635000),
        new GridCell("52VKC04", 40.42547547, -3.76045000),
        new GridCell("53VKC05", 40.42547547, -3.64455000),
        new GridCell("54VKC06", 40.42547547, -3.52865000),
        new GridCell("55VKC07", 40.42547547, -3.41275000),
        new GridCell("56VKC08", 40.42547547, -3.29685000),
        new GridCell("57VKC09", 40.42547547, -3.18095000),
        new GridCell("58VKD01", 40.33668593, -4.10815000),
        new GridCell("59VKD02", 40.33668593, -3.99225000),
        new GridCell("60VKD03", 40.33668593, -3.87635000),
        new GridCell("61VKD04", 40.33668593, -3.76045000),
        new GridCell("62VKD05", 40.33668593, -3.64455000),
        new GridCell("63VKD06", 40.33668593, -3.52865000),
        new GridCell("64VKD07", 40.33668593, -3.41275000),
        new GridCell("65VKD08", 40.33668593, -3.29685000),
        new GridCell("66VKD09", 40.33668593, -3.18095000),
        new GridCell("67VKE01", 40.24789639, -4.10815000),
        new GridCell("68VKE02", 40.24789639, -3.99225000),
        new GridCell("69VKE03", 40.24789639, -3.87635000),
        new GridCell("70VKE04", 40.24789639, -3.76045000),
        new GridCell("71VKE05", 40.24789639, -3.64455000),
        new GridCell("72VKE06", 40.24789639, -3.52865000),
        new GridCell("73VKE07", 40.24789639, -3.41275000),
        new GridCell("74VKE08", 40.24789639, -3.29685000),
        new GridCell("75VKE09", 40.24789639, -3.18095000),
        new GridCell("76VKF04", 40.15910685, -3.76045000),
        new GridCell("77VKF05", 40.15910685, -3.64455000),
        new GridCell("78VKF06", 40.15910685, -3.52865000),
        new GridCell("79VKF07", 40.15910685, -3.41275000),
        new GridCell("80VKF08", 40.15910685, -3.29685000),
        new GridCell("81VKF09", 40.15910685, -3.18095000),
        new GridCell("82VKG06", 40.07031731, -3.52865000),
        new GridCell("83VKG07", 40.07031731, -3.41275000),
        new GridCell("84VKG08", 40.07031731, -3.29685000),
        new GridCell("85VKG09", 40.07031731, -3.18095000),
        new GridCell("86VKH05", 39.98152777, -3.64455000)
    );

    /** Mapa inmutable por defecto (Scope -> lista). */
    public static final Map<Scope, List<GridCell>> DEFAULT = Map.of(
        Scope.ANDALUCIA_MALAGA, MALAGA,
        Scope.ANDALUCIA_HUELVA, HUELVA,
        Scope.MADRID,           MADRID
    );

    /** Registro mutable para configuraciones adicionales en runtime (opcional). */
    private static final Map<Scope, List<GridCell>> REGISTRY = new EnumMap<>(Scope.class);
    static {
        REGISTRY.putAll(DEFAULT);
    }

    /** Devuelve las celdas registradas para un ámbito. Nunca null (puede ser lista vacía). */
    public static List<GridCell> get(Scope scope) {
        return REGISTRY.getOrDefault(scope, List.of());
    }

    /** Permite registrar o sustituir la lista de un ámbito (extensible para "OTRA"). */
    public static void register(Scope scope, List<GridCell> cells) {
        REGISTRY.put(Objects.requireNonNull(scope),
                     Objects.requireNonNullElseGet(cells, List::of));
    }

    /** Devuelve todas las cuadrículas concatenadas en el orden de Scope. */
    public static List<GridCell> all() {
        List<GridCell> out = new ArrayList<>();
        for (Scope s : Scope.values()) out.addAll(get(s));
        return Collections.unmodifiableList(out);
    }

    /** Interfaz para inyectar tu método existente de distancia ("Mi distancia"). */
    @FunctionalInterface
    public interface DistanceCalculator {
        double distanceKm(double lat1, double lon1, double lat2, double lon2);
    }

    /** Localiza la cuadrícula más cercana a (lat, lon) dentro de 'cells'. */
    public static GridCell findNearest(double lat, double lon, Collection<GridCell> cells, DistanceCalculator dist) {
        if (cells == null || cells.isEmpty()) return null;
        Objects.requireNonNull(dist, "distance calculator es null");

        GridCell best = null;
        double bestKm = Double.POSITIVE_INFINITY;
        for (GridCell g : cells) {
            if (g == null) continue;
            double d = dist.distanceKm(lat, lon, g.centrlat(), g.centrlon()); // sin ABS
            if (Double.isNaN(d) || Double.isInfinite(d)) continue;
            if (d < bestKm || (d == bestKm && best != null && compareDen(g.denominacion(), best.denominacion()) < 0)) {
                bestKm = d;
                best = g;
            }
        }
        return best;
    }

    private static int compareDen(String a, String b) {
        if (a == null && b == null) return 0;
        if (a == null) return 1;
        if (b == null) return -1;
        return a.compareTo(b);
    }
}
