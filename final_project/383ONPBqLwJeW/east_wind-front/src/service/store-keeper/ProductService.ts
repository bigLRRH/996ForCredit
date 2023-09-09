import { EnumRsrc } from '@/api'
import ModelService from '../ModelService'
import BaseModelService from '../BaseModelService'
export default class ProductService extends BaseModelService<EnumRsrc.Product> implements ModelService {
    constructor() {
        super(EnumRsrc.Product);
    }
}