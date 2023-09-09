import useDictStore from '@/store/dict'
import { getDicts } from '@/api/system/dict/data'

/**
 * 获取字典数据
 * 从store获取，没有则请求，设置到store中
 */
export const useDict = (...args) => {
  const rsp = ref({})
  return (() => {
    args.forEach((dictType) => {
      rsp.value[dictType] = []
      const dicts = useDictStore().getDict(dictType)
      if (dicts) {
        rsp.value[dictType] = dicts
      } else {
        getDicts(dictType).then((rsp) => {
          rsp.value[dictType] = rsp.data.map((p) => ({
            label: p.dictLabel,
            value: p.dictValue,
            elTagType: p.listClass,
            elTagClass: p.cssClass
          }))
          useDictStore().setDict(dictType, rsp.value[dictType])
        })
      }
    })
    return toRefs(rsp.value)
  })()
}
