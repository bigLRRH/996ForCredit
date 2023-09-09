// #region shop-assistant
import { Sell } from './shop-assistant/Sell';
// #endregion

// #region store-keeper
import { Product } from './store-keeper/Product';
import { Store } from "./store-keeper/Store";
import { Supplier } from "./store-keeper/Supplier";
import { Supply } from './store-keeper/Supply';
import { Warehouse } from './store-keeper/Warehouse';
// #endregion

// #region system
import { User } from './system/User';
// #endregion
export enum EnumRsrc {
    // #region shop-assistant
    Sell = 'shop-assistant/sell',
    // #endregion

    // #region store-keeper
    Product = 'store-keeper/product',
    Store = 'store-keeper/store',
    Supplier = 'store-keeper/supplier',
    Supply = 'store-keeper/supply',
    Warehouse = 'store-keeper/warehouse',
    // #endregion

    // #region system
    User = 'system/user',
    // #endregion
}

export type enumRsrcTypeMap = {
    // #region shop-assistant
    [EnumRsrc.Sell]: Sell,
    // #endregion

    // #region store-keeper
    [EnumRsrc.Product]: Product,
    [EnumRsrc.Store]: Store,
    [EnumRsrc.Supplier]: Supplier,
    [EnumRsrc.Supply]: Supply,
    [EnumRsrc.Warehouse]: Warehouse,
    // #endregion

    // #region system
    [EnumRsrc.User]: User
    // #endregion
}

export function getEnumRsrcTblCols(enumRsrc: EnumRsrc): string[] {
    switch (enumRsrc) {
        // #region shop-assistant
        case EnumRsrc.Sell:
            return ['id', 'product_id', 'warehouse_id', 'quantity', 'date']
        // #endregion

        // #region store-keeper
        case EnumRsrc.Product:
            return ['id', 'name', 'category', 'price']
        case EnumRsrc.Store:
            return ['id', 'warehouse_id', 'product_id', 'quantity']
        case EnumRsrc.Supplier:
            return ['id', 'name', 'address', 'phone']
        case EnumRsrc.Supply:
            return ['id', 'supplier_id', 'product_id', 'warehouse_id', 'quantity', 'price', 'date']
        case EnumRsrc.Warehouse:
            return ['id', 'name']
        // #endregion

        // #region system
        case EnumRsrc.User:
            return ['id', 'username', 'password', 'roleCode']
        // #endregion

        default:
            return ['']
    }
}