import { EnumRsrc } from '@/api'
import ModelService from '../ModelService'
import BaseModelService from '../BaseModelService'
export default class SupplierService extends BaseModelService<EnumRsrc.Supplier> implements ModelService {
    constructor() {
        super(EnumRsrc.Supplier);
    }
}