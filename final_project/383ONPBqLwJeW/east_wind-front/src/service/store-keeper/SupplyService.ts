import { EnumRsrc } from '@/api'
import ModelService from '../ModelService'
import BaseModelService from '../BaseModelService'
import StoreService from './StoreService';
export default class SupplyService extends BaseModelService<EnumRsrc.Supply> implements ModelService {
    private storeService: StoreService = new StoreService();
    constructor() {
        super(EnumRsrc.Supply);
    }
    async supply(model) {
        this.add(model);
        const product_id = model.product_id
        if (product_id === undefined) {
            throw new Error('model id is undefined')
        }
        let store = await this.storeService.getAll()
        store = store.filter((item) => {
            return item.product_id == product_id && item.warehouse_id == model.warehouse_id
        })
        store[0].quantity += model.quantity
        this.storeService.update(store[0])
    }
}