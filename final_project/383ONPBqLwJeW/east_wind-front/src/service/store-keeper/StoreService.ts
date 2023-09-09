import { EnumRsrc } from '@/api'
import ModelService from '../ModelService'
import BaseModelService from '../BaseModelService'
export default class StoreService extends BaseModelService<EnumRsrc.Store> implements ModelService {
    constructor() {
        super(EnumRsrc.Store);
    }
}