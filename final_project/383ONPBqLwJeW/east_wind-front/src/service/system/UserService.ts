import { EnumRsrc } from '@/api'
import ModelService from '../ModelService'
import BaseModelService from '../BaseModelService'
export default class UserService extends BaseModelService<EnumRsrc.User> implements ModelService {
    constructor() {
        super(EnumRsrc.User);
    }
}