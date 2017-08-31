package com.github.coolcooldee.sloth.source.db.mysql;

import com.github.coolcooldee.sloth.parameter.DBSourceParameters;
import com.github.coolcooldee.sloth.target.JavaType;
import com.github.coolcooldee.sloth.utils.PinYinUtil;
import com.github.coolcooldee.sloth.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.*;

/**
 * Created by sloth on 16/6/17.
 */
@SuppressWarnings("unchecked")
public abstract class TableUtil {

    public static final List<String> getTableNames(Connection conn, String... tableNames) throws SQLException {

        DatabaseMetaData dme = conn.getMetaData();

        List<String> tableNanes = new ArrayList<String>();

        List<ResultSet> sets = new ArrayList<ResultSet>();

        if (tableNames != null && tableNames.length != 0) {
            for (String tableName : tableNames) {
                ResultSet rs = dme.getTables("", "", tableName, new String[]{"TABLE"});
                sets.add(rs);
            }
        } else {
            ResultSet rs = dme.getTables("", "", "", new String[]{"TABLE"});
            sets.add(rs);
        }

        List<Map> list = resToList(sets);

        for (Map map : list) {
            String tableName = map.get("TABLE_NAME").toString();
            tableNanes.add(tableName);
        }
        return tableNanes;
    }

    public static final List<Map<String, Object>> getCarrays(Connection conn, String tableName) throws Exception {
        String sql = String.format("SELECT * FROM `%s` LIMIT 1", tableName);

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> list = getColumns(rs);

        return list;
    }

    public static final String getRemark(Connection conn, String tableName, String columnName) throws Exception {
        String sql = String.format("SELECT " + "COLUMN_NAME, DATA_TYPE, "
                + "COLUMN_COMMENT FROM information_schema.columns " + "WHERE table_name  =? and COLUMN_NAME =? ");

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tableName);
        stmt.setString(2, columnName);

        ResultSet rs = stmt.executeQuery();
        String remark = null;

        while (rs.next()) {
            remark = rs.getString("COLUMN_COMMENT");
        }
        return remark;
    }


    public static final List<Map> getIndexs(Connection conn, String tableName, boolean unique) throws SQLException {
        DatabaseMetaData dmd = conn.getMetaData();
        ResultSet rs = dmd.getIndexInfo(null, null, tableName, unique, true);
        return resToList(rs);
    }

    public static final Map getBinds(Connection conn, String tableName) throws Exception {
        DatabaseMetaData dmd = conn.getMetaData();
        Map map = new HashMap();
        ResultSet rs = null;
        rs = dmd.getExportedKeys("", "", tableName);

        map.put("ExportedKeys", resToList(rs));
        rs = dmd.getImportedKeys("", "", tableName);
        map.put("ImportedKeys", resToList(rs));
        return map;
    }


    public static final List<Map> resToList(ResultSet resultSets) throws SQLException {
        List<Map> list = new ArrayList<Map>();
        while (resultSets.next()) {
            list.add(resToMap(resultSets));
        }
        return list;
    }

    public static final List<Map> resToList(List<ResultSet> resultSets) throws SQLException {
        List<Map> list = new ArrayList<Map>();
        for (int i = 0; i < resultSets.size(); i++) {
            while (resultSets.get(i).next()) {
                list.add(resToMap(resultSets.get(i)));
            }
        }
        return list;
    }


    private static final Map resToMap(ResultSet rs) throws SQLException {
        Map map = new HashMap();
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        for (int i = 1; i <= cols; i++)
            map.put(rsmd.getColumnName(i), rs.getObject(i));

        return map;
    }

    public static final List<Map<String, Object>> getColumns(ResultSet rs) throws Exception {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

        ResultSetMetaData rsmd = rs.getMetaData();

        int count = rsmd.getColumnCount();

        for (int i = 1; i <= count; i++) {
            String columnName = rsmd.getColumnName(i);
            int columnType = rsmd.getColumnType(i);
            String columnLabel = rsmd.getColumnLabel(i);
            String columnTypeName = rsmd.getColumnTypeName(i);
            String catalogName = rsmd.getCatalogName(i);
            String columnClassName = rsmd.getColumnClassName(i);
            int precision = rsmd.getPrecision(i);
            int scale = rsmd.getScale(i);
            String schemaName = rsmd.getSchemaName(i);
            String tableName = rsmd.getTableName(i);
            int columnDisplaySize = rsmd.getColumnDisplaySize(i);
            boolean isAutoIncrement = rsmd.isAutoIncrement(i);
            boolean isCaseSensitive = rsmd.isCaseSensitive(i);
            boolean isCurrency = rsmd.isCurrency(i);
            boolean isDefinitelyWritable = rsmd.isDefinitelyWritable(i);
            int isNullable = rsmd.isNullable(i);
            boolean isReadOnly = rsmd.isReadOnly(i);
            boolean isSearchable = rsmd.isSearchable(i);
            boolean isSigned = rsmd.isSigned(i);
            boolean isWritable = rsmd.isWritable(i);

            @SuppressWarnings("rawtypes")
            Map e = new HashMap();
            e.put("i", i);
            e.put("columnName", columnName);
            e.put("columnType", columnType);
            e.put("columnLabel", columnLabel);
            e.put("columnTypeName", columnTypeName);
            e.put("catalogName", catalogName);
            e.put("columnClassName", columnClassName);
            e.put("precision", precision);
            e.put("scale", scale);
            e.put("schemaName", schemaName);
            e.put("tableName", tableName);
            e.put("columnDisplaySize", columnDisplaySize);
            e.put("isAutoIncrement", isAutoIncrement);
            e.put("isCaseSensitive", isCaseSensitive);
            e.put("isCurrency", isCurrency);
            e.put("isDefinitelyWritable", isDefinitelyWritable);
            e.put("isNullable", isNullable);
            e.put("isReadOnly", isReadOnly);
            e.put("isSearchable", isSearchable);
            e.put("isSigned", isSigned);
            e.put("isWritable", isWritable);
            e.put("javaForType", JavaType.getBasicType(JavaType.getType(rsmd, columnLabel)));
            ret.add(e);
        }
        return ret;
    }

    public static final List<Table> getTables(Connection conn, String packageName, String[] tableNames)
            throws Exception {

        List<Table> tables = new ArrayList<Table>();

        Table table = null;

        List<String> tabelNames = getTableNames(conn, tableNames);

        StringBuilder tableNamesStr = new StringBuilder();

        for(int i=0;i<tabelNames.size(); i++){
            if(i>0){
                tableNamesStr.append(",");
            }
            tableNamesStr.append(tabelNames.get(i));
        }

        for (String tableName : tabelNames) {
            String className_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(StringUtil.newTableName(tableName)));
            String className_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(StringUtil.newTableName(tableName)));
            List<TableIndex> tableIndexs = getTableIndexs(conn, tableName);
            List<TableBind> tableBinds = getTableBinds(conn, tableName);
            Set<String> upperTableNames = new HashSet<String>();
            upperTableNames.add(className_d);
            for (TableBind tableBind : tableBinds) {
                upperTableNames.add(tableBind.getTableName_d());
            }

            String stringCarrayNames1 = "";
            String stringCarrayNames2 = "";
            String stringCarrayNames3 = "";
            String stringCarrayNames4 = "";
            String stringCarrayNames5 = "";

            String stringCarrayNames6 = "";
            String stringCarrayNames7 = "";

            List<Column> columns = getTableCarrays(conn, tableName);

            for (Column column : columns) {

                String remark = getRemark(conn, tableName, column.getName());
                column.setRemark(remark);

                if (!"".endsWith(stringCarrayNames1)) {
                    stringCarrayNames1 += ", ";
                }
                if (!"".endsWith(stringCarrayNames2)) {
                    stringCarrayNames2 += ", ";
                }
                if (!"".endsWith(stringCarrayNames3)) {
                    stringCarrayNames3 += ", ";
                }
                if (!"".endsWith(stringCarrayNames4)) {
                    stringCarrayNames4 += ", ";
                }
                if (!"".endsWith(stringCarrayNames5)) {
                    stringCarrayNames5 += ", ";
                }
                //
                stringCarrayNames1 += column.getLowerFirstLetterName();

                stringCarrayNames2 += column.getType() + " " + column.getLowerFirstLetterName();

                if(!column.isAutoIncrement()) { //如果是主键，不需要在 insert 语句中 (Mabatis)
                    stringCarrayNames3 += "`"+column.getName()+"`";
                }
                if(!column.isAutoIncrement()) { //如果是主键，不需要在 insert 语句中 (Mabatis)
                    stringCarrayNames4 += String.format("#{%s}", column.getLowerFirstLetterName());
                }
                if(!column.isAutoIncrement()) { //如果是主键，不需要在 insert 语句中 (Mabatis)
                    stringCarrayNames5 += String.format("%s=#{%s}", column.getName(),
                            column.getLowerFirstLetterName());
                }

                if (!column.getName().equals("ID") && !column.getName().equals("id")) {

                    if (!"".endsWith(stringCarrayNames6)) {
                        stringCarrayNames6 += ", ";
                    }

                    if (!"".endsWith(stringCarrayNames7)) {
                        stringCarrayNames7 += ", ";
                    }
                    stringCarrayNames6 += column.getName();

                    stringCarrayNames7 += String.format("#{%s}", column.getLowerFirstLetterName());
                }
            }

            table = new Table(tableName, className_d, className_x, packageName, columns, tableIndexs, tableBinds,
                    upperTableNames, stringCarrayNames1, stringCarrayNames2, stringCarrayNames3, stringCarrayNames4,
                    stringCarrayNames5, stringCarrayNames6, stringCarrayNames7);
            String stringCarrayNames8 = "";
            table.setUpperName(tableName.toUpperCase());
            table.setAllTablesName(tableNamesStr.toString());
            table.setSourceDbSchema(DBSourceParameters.getSourceDbSchema());

            if (table.getPrimaryKey() == null) {
                //ResultSet trs = conn.getMetaData().getColumns(null, "%", tableName,"%");
                ResultSet rs = conn.getMetaData().getPrimaryKeys(null, "%", tableName);
                while (rs.next()) {
                    String primaryKey = rs.getString("COLUMN_NAME");
                    String primaryKeyType = "";
                    for(Column column :columns){
                        if(primaryKey.equals(column.getName()))
                            primaryKeyType = column.getType();
                    }
                    table.setPrimaryKey(primaryKey);
                    table.setPrimaryKeyType(primaryKeyType);
                    table.setLowerFirstLetterPrimaryKey(StringUtil.lowerFirst(StringUtil.newTableName(primaryKey)));
                    table.setUpperFirstLetterPrimaryKey(StringUtil.upperFirst(StringUtil.newTableName(primaryKey)));
                    stringCarrayNames8 += String.format("%s=#{%s}", primaryKey, table.getLowerFirstLetterPrimaryKey());
                }

                if(StringUtils.isBlank(table.getPrimaryKey())){
                    throw new NullPointerException("table '"+tableName + "' without primary key, please setting the " +
                            "primary key.");
                }

            }
            if (!stringCarrayNames8.equals("")) {
                table.setStringCarrayNames8(stringCarrayNames8);
            }

            tables.add(table);
        }

        return tables;
    }

    /**
     * @param conn
     * @param tableName
     * @return
     * @throws Exception
     */
    public static final List<Column> getTableCarrays(Connection conn, String tableName) throws Exception {

        List<Column> columns = new ArrayList<Column>();
        Column tabelCarray = null;

        List<Map<String, Object>> carrays = getCarrays(conn, tableName);

        for (Map<String, Object> map : carrays) {

            String columnLabel = map.get("columnLabel").toString();

            String carrayName_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(StringUtil.newTableName(columnLabel)));

            String carrayName_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(StringUtil.newTableName(columnLabel)));

            boolean autoIncrement = "true".equals(map.get("isAutoIncrement").toString());

            String carrayType = map.get("javaForType").toString();
            if (carrayType.equals("int")) {
                carrayType = "Integer";
            } else if (carrayType.equals("short")) {
                carrayType = "Short";
            } else if (carrayType.equals("java.utils.Date")) {
                carrayType = "String";
            } else if (carrayType.equals("java.sql.Time")) {
                carrayType = "String";
            } else if (carrayType.equals("boolean")) {
                carrayType = "Integer";
            } else if (carrayType.equals("double")) {
                carrayType = "Double";
            } else if (carrayType.equals("long")) {
                carrayType = "Long";
            }

            tabelCarray = new Column(columnLabel, carrayName_d, carrayName_x, carrayType, "", autoIncrement);
            columns.add(tabelCarray);
        }
        return columns;
    }

    public static final List<TableIndex> getTableIndexs(Connection conn, String tableName) throws Exception {
        List<Map> indexs = getIndexs(conn, tableName, false);
        Map<String, String> carrayTypes = getTableCarrayTypes(conn, tableName);
        Map<String, List<Map>> _index = new HashMap<String, List<Map>>();
        for (Map map : indexs) {
            String indexName = map.get("INDEX_NAME").toString();
            List<Map> list = _index.remove(indexName);
            if (list == null) {
                list = new ArrayList<Map>();
            }
            list.add(map);
            _index.put(indexName, list);
        }

        List<TableIndex> tableIndexs = new ArrayList<TableIndex>();
        TableIndex tabelIndex = null;
        Iterator it = _index.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            String indexName = e.getKey().toString();
            boolean unique = false;
            List<String> carrayNames = new ArrayList<String>();
            List<String> carrayNames_d = new ArrayList<String>();
            List<String> carrayNames_x = new ArrayList<String>();
            List<Map<String, String>> carrayNameMaps = new ArrayList<Map<String, String>>();
            String stringCarrayNames1 = "";
            String stringCarrayNames2 = "";
            String stringCarrayNames3 = "";
            String stringCarrayNames4 = "";
            String stringCarrayNames5 = "";
            List<Map> vals = (List<Map>) e.getValue();
            for (Map map : vals) {
                String carrayName = map.get("COLUMN_NAME").toString();
                unique = "false".equals(map.get("NON_UNIQUE").toString());
                String carrayName_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(StringUtil
                        .newTableName(carrayName)));
                String carrayName_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(StringUtil
                        .newTableName(carrayName)));
                carrayNames.add(carrayName);
                carrayNames_d.add(carrayName_d);
                carrayNames_x.add(carrayName_x);
                Map<String, String> carrayNameMap = new HashMap<String, String>();
                carrayNameMap.put("carrayName", carrayName);
                carrayNameMap.put("carrayName_x", carrayName_x);
                carrayNameMaps.add(carrayNameMap);
                stringCarrayNames1 += carrayName_d;
                if (!"".equals(stringCarrayNames2)) {
                    stringCarrayNames2 += ", ";
                }
                if (!"".equals(stringCarrayNames3)) {
                    stringCarrayNames3 += ", ";
                }
                if (!"".equals(stringCarrayNames4)) {
                    stringCarrayNames4 += ", ";
                }
                if (!"".equals(stringCarrayNames5)) {
                    stringCarrayNames5 += ", ";
                }
                stringCarrayNames2 += carrayName;
                stringCarrayNames3 += carrayTypes.get(carrayName_d) + " " + carrayName_x;
                stringCarrayNames4 += carrayName_x;
                stringCarrayNames5 += String.format("%s=#{%s}", carrayName, carrayName_x);
            }
            tabelIndex = new TableIndex(indexName, carrayNames, carrayNames_d, carrayNames_x, carrayNameMaps,
                    stringCarrayNames1, stringCarrayNames2, stringCarrayNames3, stringCarrayNames4, stringCarrayNames5,
                    unique);
            tableIndexs.add(tabelIndex);
        }
        return tableIndexs;
    }

    public static final Map<String, String> getTableCarrayTypes(Connection conn, String tableName) throws Exception {
        Map<String, String> tableCarrayTypes = new HashMap<String, String>();
        List<Map<String, Object>> carrays = getCarrays(conn, tableName);
        for (Map<String, Object> map : carrays) {
            String columnLabel = map.get("columnLabel").toString();
            String carrayName_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(columnLabel));
            String carrayType = map.get("javaForType").toString();
            tableCarrayTypes.put(carrayName_d, carrayType);
        }
        return tableCarrayTypes;
    }

    public static final List<TableBind> getTableBinds(Connection conn, String tableName) throws Exception {
        List<TableBind> tableBinds = new ArrayList<TableBind>();
        TableBind tableBind = null;
        Map map = getBinds(conn, tableName);

        String keyName = "";
        String keyType = "";
        String carrayName = "";
        String table_Name = "";
        String carrayName_d = "";
        String carrayName_x = "";
        String table_Name_d = "";
        String table_Name_x = "";

        List<Map> exportedKeys = (List<Map>) map.get("ExportedKeys");
        for (Map exportedKey : exportedKeys) {
            keyName = exportedKey.get("FK_NAME").toString();
            keyType = "exportedKey";
            carrayName = exportedKey.get("FKCOLUMN_NAME").toString();
            table_Name = exportedKey.get("FKTABLE_NAME").toString();
            carrayName_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(carrayName));
            carrayName_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(carrayName));
            table_Name_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(table_Name));
            table_Name_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(table_Name));
            tableBind = new TableBind(keyName, keyType, table_Name_d, table_Name_x, carrayName_d, carrayName_x);
            tableBinds.add(tableBind);
        }
        List<Map> importedKeys = (List<Map>) map.get("ImportedKeys");
        for (Map importedKey : importedKeys) {
            keyName = importedKey.get("FK_NAME").toString();
            keyType = "importedKey";
            carrayName = importedKey.get("FKCOLUMN_NAME").toString();
            table_Name = importedKey.get("PKTABLE_NAME").toString();
            carrayName_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(carrayName));
            carrayName_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(carrayName));
            table_Name_d = StringUtil.upperFirst(PinYinUtil.getFirstSpell(table_Name));
            table_Name_x = StringUtil.lowerFirst(PinYinUtil.getFirstSpell(table_Name));
            tableBind = new TableBind(keyName, keyType, table_Name_d, table_Name_x, carrayName_d, carrayName_x);
            tableBinds.add(tableBind);
        }
        return tableBinds;
    }


}
