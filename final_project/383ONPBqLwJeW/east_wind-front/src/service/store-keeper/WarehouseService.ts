import { EnumRsrc } from '@/api'
import ModelService from '../ModelService'
import BaseModelService from '../BaseModelService'
export default class WarehouseService extends BaseModelService<EnumRsrc.Warehouse> implements ModelService {
    constructor() {
        super(EnumRsrc.Warehouse);
    }
}