import request from '@/utils/request'

export function getList(data) {
  return request({
    url: '/user/list',
    method: 'post',
    data
  })
}
